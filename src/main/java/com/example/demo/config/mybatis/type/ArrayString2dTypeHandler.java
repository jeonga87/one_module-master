/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2016 Vladislav Zablotsky
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package com.example.demo.config.mybatis.type;

import org.apache.ibatis.type.MappedTypes;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Multi dimensional array handler.
 *
 * PostgreSQL require that such arrays must be as matrix - all rows must have same amount of elements.
 */
@MappedTypes(String[][].class)
public class ArrayString2dTypeHandler extends ArrayTypeHandler<String[][]> {

    @Override
    protected String getDbTypeName(Connection connection) throws SQLException {
        String db = connection.getMetaData().getDatabaseProductName();
        return ArrayStringTypeHandler.getTypeForDb(db);
    }

    @Override
    protected String[][] toEmptyValue(Object[] value) {
        return new String[0][0];
    }
}
