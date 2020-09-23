package com.ademe.mapretro.utils.map

import android.content.res.AssetManager
import android.util.Log
import com.google.android.gms.maps.model.Tile
import com.google.android.gms.maps.model.TileProvider
import java.io.ByteArrayOutputStream
import java.io.IOException
import java.io.InputStream

class LocalTileProvider(private val mAssets: AssetManager) : TileProvider {

    private var cachedHashMap: HashMap<String, Tile?> = hashMapOf()

    override fun getTile(x: Int, y: Int, zoom: Int): Tile? {
        val title = getTileFilename(x, y, zoom)
        val image = readTileImage(title)

        image?.let {
            if (cachedHashMap[title] == null) {
                cachedHashMap[title] = Tile(
                    TILE_WIDTH,
                    TILE_HEIGHT, it)
            }
            return cachedHashMap[title]
        } ?: return null
    }

    private fun readTileImage(title: String): ByteArray? {
        var `in`: InputStream? = null
        var buffer: ByteArrayOutputStream? = null
        return try {
            `in` = mAssets.open(title)
            buffer = ByteArrayOutputStream()
            var nRead: Int
            val data = ByteArray(BUFFER_SIZE)
            while (`in`.read(data, 0,
                    BUFFER_SIZE
                ).also { nRead = it } != -1) {
                buffer.write(data, 0, nRead)
            }
            buffer.flush()
            buffer.toByteArray()
        } catch (e: IOException) {
            Log.d("MAP_TILE", "File $title does not exist")
            null
        } catch (e: OutOfMemoryError) {
            Log.e("MAP_TILE", "Memory error")
            null
        } finally {
            if (`in` != null) try {
                `in`.close()
            } catch (ignored: Exception) {
            }
            if (buffer != null) try {
                buffer.close()
            } catch (ignored: Exception) {
            }
        }
    }

    private fun getTileFilename(x: Int, y: Int, zoom: Int): String {
        return "map/$zoom/$x/$y.png"
    }

    companion object {
        private const val TILE_WIDTH = 256
        private const val TILE_HEIGHT = 256
        private const val BUFFER_SIZE = 16 * 1024
    }
}