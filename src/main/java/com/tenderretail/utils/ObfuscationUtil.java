/*
 * Contactless Cons WebApp by Brian Donaldson
 * Copyright (c) 2020.  Brian Donaldson
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.tenderretail.utils;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;

import org.apache.commons.codec.binary.Hex;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ObfuscationUtil {
    private static final Logger LOGGER = LoggerFactory.getLogger(ObfuscationUtil.class);

    public static String obfuscateData(String data) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] encodedhash = digest.digest(data.getBytes(StandardCharsets.UTF_8));
            return new String(Hex.encodeHex(encodedhash));
        } catch (Exception e) {
            LOGGER.error("error hashing data, outputting empty string instead");
            return "";
        }
    }
}
