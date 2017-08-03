/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package polosoft.sourav.poloniex.poloniexlive.Alert;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Alert_UIDatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "Alertdb.db";
    private static final int DATABASE_VERSION = 1;

    public Alert_UIDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String SQL_CREATE_PETS_TABLE = "CREATE TABLE " + Alert_UIPetContract.PetEntry.TABLE_NAME + " ("
                + Alert_UIPetContract.PetEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + Alert_UIPetContract.PetEntry.COLUMN_ALERT_CoinCode + " TEXT NOT NULL, "
                + Alert_UIPetContract.PetEntry.COLUMN_ALERT_CoinName + " TEXT, "
                + Alert_UIPetContract.PetEntry.COLUMN_ALERT_PriceLowHigh + " TEXT NOT NULL DEFAULT 0, "
                + Alert_UIPetContract.PetEntry.COLUMN_ALERT_PriceLow + " TEXT NOT NULL, "

                + Alert_UIPetContract.PetEntry.COLUMN_ALERT_Note + " TEXT, "
                + Alert_UIPetContract.PetEntry.COLUMN_ALERT_Type + " TEXT );";

        db.execSQL(SQL_CREATE_PETS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + Alert_UIPetContract.PetEntry.TABLE_NAME );

        // Create tables again
        onCreate(db); }







    }



















