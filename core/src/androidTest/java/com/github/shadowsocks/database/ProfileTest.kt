/*******************************************************************************
 *                                                                             *
 *  Copyright (C) 2017 by Max Lv <max.c.lv@gmail.com>                          *
 *  Copyright (C) 2017 by Mygod Studio <contact-shadowsocks-android@mygod.be>  *
 *                                                                             *
 *  This program is free software: you can redistribute it and/or modify       *
 *  it under the terms of the GNU General Public License as published by       *
 *  the Free Software Foundation, either version 3 of the License, or          *
 *  (at your option) any later version.                                        *
 *                                                                             *
 *  This program is distributed in the hope that it will be useful,            *
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of             *
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the              *
 *  GNU General Public License for more details.                               *
 *                                                                             *
 *  You should have received a copy of the GNU General Public License          *
 *  along with this program. If not, see <http://www.gnu.org/licenses/>.       *
 *                                                                             *
 *******************************************************************************/

package com.github.shadowsocks.database

import androidx.core.net.toUri
import org.junit.Assert
import org.junit.Test

class ProfileTest {
    @Test
    fun parsing() {
        val results = Profile.findAllUrls("garble ss://YmYtY2ZiOnRlc3RAMTkyLjE2OC4xMDAuMTo4ODg4#example-server garble")
                .toList()
        Assert.assertEquals(1, results.size)
        Assert.assertEquals("ss://YmYtY2ZiOnRlc3Q@192.168.100.1:8888#example-server".toUri(),
                results.single().toUri())
    }
}

class ProfileUS {
    @US
    fun parsing() {
        val results = Profile.findAllUrls("garble ss://Y2hhY2hhMjA6IWNodWRpa2hhbmtpIUAyMDYuMTg5LjIxOS4xNTY6Njk5#us-server garble")
                .toList()
        Assert.assertEquals(1, results.size)
        Assert.assertEquals("ss://chacha20:!chudikhanki!@206.189.219.156:699#us-server".toUri(),
                results.single().toUri())
    }

