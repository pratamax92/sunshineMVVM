package id.gits.stroomheadapi.dao;

import java.io.Serializable;
import java.util.List;

public class WeatherDao {
    public List<Details> list;

    public class Details {
        public String dt;
        public Temp temp;
        public List<Weather> weather;

        public class Temp {
            public String min;
            public String max;
        }

        public class Weather {
            public String main;
            public String description;
        }


    }

}