/*
 * Copyright 2013 MovingBlocks
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.terasology.persistence.typeHandling.mathTypes;


import gnu.trove.list.TFloatList;

import org.terasology.math.geom.Vector2f;
import org.terasology.persistence.typeHandling.DeserializationContext;
import org.terasology.persistence.typeHandling.PersistedData;
import org.terasology.persistence.typeHandling.PersistedDataArray;
import org.terasology.persistence.typeHandling.SerializationContext;
import org.terasology.persistence.typeHandling.SimpleTypeHandler;

/**
 * @author Immortius <immortius@gmail.com>
 */
public class Vector2fTypeHandler extends SimpleTypeHandler<Vector2f> {

    @Override
    public PersistedData serialize(Vector2f value, SerializationContext context) {
        return context.create(value.x, value.y);
    }

    @Override
    public Vector2f deserialize(PersistedData data, DeserializationContext context) {
        if (data.isArray()) {
            PersistedDataArray dataArray = data.getAsArray();
            if (dataArray.isNumberArray() && dataArray.size() > 1) {
                TFloatList floats = dataArray.getAsFloatArray();
                return new Vector2f(floats.get(0), floats.get(1));
            }
        }
        return null;
    }
}
