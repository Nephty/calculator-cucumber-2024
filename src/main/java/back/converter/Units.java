package back.converter;

import java.util.ArrayList;
import java.util.List;

public final class Units {
    private Units() {
        throw new IllegalStateException("Utility class");
    }

    /**
     * @return A list of all unit types (speed, weight...) as classes.
     */
    public static List<Class<? extends Unit>> getUnitClasses() {
        List<Class<? extends Unit>> unitClasses = new ArrayList<>();
        unitClasses.add(Speed.class);
        unitClasses.add(Weight.class);
        unitClasses.add(Distance.class);
        unitClasses.add(Time.class);
        unitClasses.add(Angles.class);
        return unitClasses;
    }

    public interface Unit {
        String getSymbol();
    }

    public enum Speed implements Unit {
        MILLIMETERS_PER_SECOND {
            @Override
            public String getSymbol() {
                return "mm/s";
            }
        },
        MILLIMETERS_PER_HOUR {
            @Override
            public String getSymbol() {
                return "mm/h";
            }
        },
        CENTIMETERS_PER_SECOND {
            @Override
            public String getSymbol() {
                return "cm/s";
            }
        },
        CENTIMETERS_PER_HOUR {
            @Override
            public String getSymbol() {
                return "cm/h";
            }
        },
        DECIMETERS_PER_SECOND {
            @Override
            public String getSymbol() {
                return "dm/s";
            }
        },
        DECIMETERS_PER_HOUR {
            @Override
            public String getSymbol() {
                return "dm/h";
            }
        },
        METERS_PER_SECOND {
            @Override
            public String getSymbol() {
                return "m/s";
            }
        },
        METERS_PER_HOUR {
            @Override
            public String getSymbol() {
                return "m/h";
            }
        },
        KILOMETERS_PER_SECOND {
            @Override
            public String getSymbol() {
                return "km/s";
            }
        },
        KILOMETERS_PER_HOUR {
            @Override
            public String getSymbol() {
                return "km/h";
            }
        },
        INCHES_PER_SECOND {
            @Override
            public String getSymbol() {
                return "in/s";
            }
        },
        INCHES_PER_HOUR {
            @Override
            public String getSymbol() {
                return "in/h";
            }
        },
        FEET_PER_SECOND {
            @Override
            public String getSymbol() {
                return "ft/s";
            }
        },
        FEET_PER_HOUR {
            @Override
            public String getSymbol() {
                return "ft/h";
            }
        },
        YARDS_PER_SECOND {
            @Override
            public String getSymbol() {
                return "yd/s";
            }
        },
        YARDS_PER_HOUR {
            @Override
            public String getSymbol() {
                return "yd/h";
            }
        },
        MILES_PER_SECOND {
            @Override
            public String getSymbol() {
                return "mi/s";
            }
        },
        MILES_PER_HOUR {
            @Override
            public String getSymbol() {
                return "mi/h";
            }
        },
        KNOT {
            @Override
            public String getSymbol() {
                return "kt";
            }
        },
        MACH {
            @Override
            public String getSymbol() {
                return "M";
            }
        }
    }

    public enum Weight implements Unit {
        MILLIGRAM {
            @Override
            public String getSymbol() {
                return "mg";
            }
        },
        CENTIGRAM {
            @Override
            public String getSymbol() {
                return "cg";
            }
        },
        DECIGRAM {
            @Override
            public String getSymbol() {
                return "dg";
            }
        },
        GRAM {
            @Override
            public String getSymbol() {
                return "g";
            }
        },
        KILOGRAM {
            @Override
            public String getSymbol() {
                return "kg";
            }
        },
        TON {
            @Override
            public String getSymbol() {
                return "T";
            }
        },
        OUNCE {
            @Override
            public String getSymbol() {
                return "oz";
            }
        },
        POUND {
            @Override
            public String getSymbol() {
                return "lbs";
            }
        },
        CARAT {
            @Override
            public String getSymbol() {
                return "ct";
            }
        },
        EMPTY_CLUB_MATE_BOTTLE {
            @Override
            public String getSymbol() {
                return "ecmb";
            }
        }
    }

    public enum Distance implements Unit {
        MILLIMETER {
            @Override
            public String getSymbol() {
                return "mm";
            }
        },
        CENTIMETER {
            @Override
            public String getSymbol() {
                return "cm";
            }
        },
        DECIMETER {
            @Override
            public String getSymbol() {
                return "dm";
            }
        },
        METER {
            @Override
            public String getSymbol() {
                return "m";
            }
        },
        KILOMETER {
            @Override
            public String getSymbol() {
                return "km";
            }
        },
        INCH {
            @Override
            public String getSymbol() {
                return "in";
            }
        },
        FOOT {
            @Override
            public String getSymbol() {
                return "ft";
            }
        },
        YARD {
            @Override
            public String getSymbol() {
                return "yd";
            }
        },
        MILE {
            @Override
            public String getSymbol() {
                return "mi";
            }
        },
        NAUTICAL_MILE {
            @Override
            public String getSymbol() {
                return "NM";
            }
        },
        LIGHT_YEAR {
            @Override
            public String getSymbol() {
                return "ly";
            }
        },
    }

    public enum Time implements Unit {
        SECOND {
            @Override
            public String getSymbol() {
                return "s";
            }
        },
        HOUR {
            @Override
            public String getSymbol() {
                return "h";
            }
        }
    }

    public enum Angles implements Unit {
        DEGREE {
            @Override
            public String getSymbol() {
                return "deg";
            }
        },
        RADIAN {
            @Override
            public String getSymbol() {
                return "rad";
            }
        }
    }
}
