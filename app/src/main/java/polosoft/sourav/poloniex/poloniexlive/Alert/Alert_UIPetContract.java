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

import android.provider.BaseColumns;

public final class Alert_UIPetContract {
    private Alert_UIPetContract() {}

    public static final class PetEntry implements BaseColumns {
        public final static String TABLE_NAME = "Alerts";
      public final static String _ID = BaseColumns._ID;
        public final static String COLUMN_ALERT_CoinCode ="CoinCode";
        public final static String COLUMN_ALERT_CoinName = "CoinName";
        public final static String COLUMN_ALERT_PriceLowHigh = "PriceHigh";
        public final static String COLUMN_ALERT_PriceLow = "PriceLow";
        public final static String COLUMN_ALERT_Note = "Note";
        public final static String COLUMN_ALERT_Type = "Type";

    }

}
