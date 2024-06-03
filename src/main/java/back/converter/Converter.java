package back.converter;

import back.calculator.types.AbstractValue;
import back.calculator.types.MyNumber;
import back.calculator.types.NotANumber;

import back.calculator.types.RealValue;

import java.math.BigDecimal;
import java.util.EnumMap;
import back.calculator.App;
import java.util.Map;

/**
 * This class provides all conversion methods.
 * For each type of unit (distance, time...), the converter first converts the input into a reference unit (for example,
 * meter in the case of distance) and then converts the result into the request unit. This avoids repetitive factors
 * declarations.
 */
public final class Converter {
    /**
     * Holds the conversion factors from all speed units to all speed units.
     */
    private static final Map<Units.Speed, Map<Units.Speed, RealValue>> speedConversionFactors = new EnumMap<>(Units.Speed.class);
    /**
     * Holds the conversion factors from all weight units to all speed units.
     */
    private static final Map<Units.Weight, Map<Units.Weight, RealValue>> weightConversionFactors = new EnumMap<>(Units.Weight.class);
    /**
     * Holds the conversion factors from all distance units to all speed units.
     */
    private static final Map<Units.Distance, Map<Units.Distance, RealValue>> distanceConversionFactors = new EnumMap<>(Units.Distance.class);
    /**
     * Holds the conversion factors from all time units to all speed units.
     */
    private static final Map<Units.Time, Map<Units.Time, RealValue>> timeConversionFactors = new EnumMap<>(Units.Time.class);
    /**
     * Holds the conversion factors from all angles units to all angles units.
     */
    private static final Map<Units.Angles, Map<Units.Angles, RealValue>> anglesConversionFactors = new EnumMap<>(Units.Angles.class);

    static {
        initializeSpeedConversionFactors();
        initializeWeightConversionFactors();
        initializeDistanceConversionFactors();
        initializeTimeConversionFactors();
        initializeAnglesConversionFactors();
    }

    private Converter() {
        throw new IllegalStateException("Utility class");
    }

    /**
     * Defines the conversion factors for all speed units.
     */
    private static void initializeSpeedConversionFactors() {
        initializeSpeedConversionFactorsMetersPerSecond();
        initializeSpeedConversionFactorsMetersPerHour();
        initializeSpeedConversionFactorsMillimetersPerSecond();
        initializeSpeedConversionFactorsMillimetersPerHour();
        initializeSpeedConversionFactorsCentimetersPerSecond();
        initializeSpeedConversionFactorsCentimetersPerHour();
        initializeSpeedConversionFactorsDecimetersPerSecond();
        initializeSpeedConversionFactorsDecimetersPerHour();
        initializeSpeedConversionFactorsKilometersPerSecond();
        initializeSpeedConversionFactorsKilometersPerHour();
        initializeSpeedConversionFactorsInchesPerSecond();
        initializeSpeedConversionFactorsInchesPerHour();
        initializeSpeedConversionFactorsFeetPerSecond();
        initializeSpeedConversionFactorsFeetPerHour();
        initializeSpeedConversionFactorsYardsPerSecond();
        initializeSpeedConversionFactorsYardsPerHour();
        initializeSpeedConversionFactorsMilesPerSecond();
        initializeSpeedConversionFactorsMilesPerHour();
        initializeSpeedConversionFactorsKnot();
        initializeSpeedConversionFactorsMach();
    }

    /**
     * Initializes the conversion factors for meters per second.
     */
    private static void initializeSpeedConversionFactorsMetersPerSecond() {
        Map<Units.Speed, RealValue> factors = new EnumMap<>(Units.Speed.class);
        factors.put(Units.Speed.MILLIMETERS_PER_SECOND, new RealValue(new BigDecimal(Float.toString(1000f), App.getPrecision())));
        factors.put(Units.Speed.MILLIMETERS_PER_HOUR, new RealValue(new BigDecimal(Float.toString(3600000f), App.getPrecision())));
        factors.put(Units.Speed.CENTIMETERS_PER_SECOND, new RealValue(new BigDecimal(Float.toString(100f), App.getPrecision())));
        factors.put(Units.Speed.CENTIMETERS_PER_HOUR, new RealValue(new BigDecimal(Float.toString(360000f), App.getPrecision())));
        factors.put(Units.Speed.DECIMETERS_PER_SECOND, new RealValue(new BigDecimal(Float.toString(10f), App.getPrecision())));
        factors.put(Units.Speed.DECIMETERS_PER_HOUR, new RealValue(new BigDecimal(Float.toString(36000f), App.getPrecision())));
        factors.put(Units.Speed.METERS_PER_SECOND, new RealValue(new BigDecimal(Float.toString(1f), App.getPrecision())));
        factors.put(Units.Speed.METERS_PER_HOUR, new RealValue(new BigDecimal(Float.toString(3600f), App.getPrecision())));
        factors.put(Units.Speed.KILOMETERS_PER_SECOND, new RealValue(new BigDecimal(Float.toString(1f/1000), App.getPrecision())));
        factors.put(Units.Speed.KILOMETERS_PER_HOUR, new RealValue(new BigDecimal(Float.toString(3.6f), App.getPrecision())));
        factors.put(Units.Speed.INCHES_PER_SECOND, new RealValue(new BigDecimal(Float.toString(39.37007874015748f), App.getPrecision())));
        factors.put(Units.Speed.INCHES_PER_HOUR, new RealValue(new BigDecimal(Float.toString(141732.28346457f), App.getPrecision())));
        factors.put(Units.Speed.FEET_PER_SECOND, new RealValue(new BigDecimal(Float.toString(3.280839895f), App.getPrecision())));
        factors.put(Units.Speed.FEET_PER_HOUR, new RealValue(new BigDecimal(Float.toString(11811.023622f), App.getPrecision())));
        factors.put(Units.Speed.YARDS_PER_SECOND, new RealValue(new BigDecimal(Float.toString(1.0936132983f), App.getPrecision())));
        factors.put(Units.Speed.YARDS_PER_HOUR, new RealValue(new BigDecimal(Float.toString(3937.007874f), App.getPrecision())));
        factors.put(Units.Speed.MILES_PER_SECOND, new RealValue(new BigDecimal(Float.toString(0.0006213712f), App.getPrecision())));
        factors.put(Units.Speed.MILES_PER_HOUR, new RealValue(new BigDecimal(Float.toString(2.2369362921f), App.getPrecision())));
        factors.put(Units.Speed.KNOT, new RealValue(new BigDecimal(Float.toString(1.9438444924f), App.getPrecision())));
        factors.put(Units.Speed.MACH, new RealValue(new BigDecimal(Float.toString(0.0033892974f), App.getPrecision())));
        speedConversionFactors.put(Units.Speed.METERS_PER_SECOND, factors);
    }

    /**
     * Initializes the conversion factor for meters per hour to meters per second.
     */
    private static void initializeSpeedConversionFactorsMetersPerHour() {
        Map<Units.Speed, RealValue> factors = new EnumMap<>(Units.Speed.class);
        factors.put(Units.Speed.METERS_PER_SECOND, new RealValue(new BigDecimal(Float.toString(1f/3600), App.getPrecision())));
        speedConversionFactors.put(Units.Speed.METERS_PER_HOUR, factors);
    }

    /**
     * Initializes the conversion factor for millimeters per second to meters per second.
     */
    private static void initializeSpeedConversionFactorsMillimetersPerSecond() {
        Map<Units.Speed, RealValue> factors = new EnumMap<>(Units.Speed.class);
        factors.put(Units.Speed.METERS_PER_SECOND, new RealValue(new BigDecimal(Float.toString(0.001f), App.getPrecision())));
        speedConversionFactors.put(Units.Speed.MILLIMETERS_PER_SECOND, factors);
    }

    /**
     * Initializes the conversion factors for millimeters per hour to meters per second
     */
    private static void initializeSpeedConversionFactorsMillimetersPerHour() {
        Map<Units.Speed, RealValue> factors = new EnumMap<>(Units.Speed.class);
        factors.put(Units.Speed.METERS_PER_SECOND, new RealValue(new BigDecimal(Float.toString(2.777777777E-7f), App.getPrecision())));
        speedConversionFactors.put(Units.Speed.MILLIMETERS_PER_HOUR, factors);
    }

    /**
     * Initializes the conversion factors for centimeters per second to meters per second.
     */
    private static void initializeSpeedConversionFactorsCentimetersPerSecond() {
        Map<Units.Speed, RealValue> factors = new EnumMap<>(Units.Speed.class);
        factors.put(Units.Speed.METERS_PER_SECOND, new RealValue(new BigDecimal(Float.toString(0.01f), App.getPrecision())));
        speedConversionFactors.put(Units.Speed.CENTIMETERS_PER_SECOND, factors);
    }

    /**
     * Initializes the conversion factors for centimeters per hour to meters per second
     */
    private static void initializeSpeedConversionFactorsCentimetersPerHour() {
        Map<Units.Speed, RealValue> factors = new EnumMap<>(Units.Speed.class);
        factors.put(Units.Speed.METERS_PER_SECOND, new RealValue(new BigDecimal(Float.toString(2.777777777E-6f), App.getPrecision())));
        speedConversionFactors.put(Units.Speed.CENTIMETERS_PER_HOUR, factors);
    }

    /**
     * Initializes the conversion factors for decimeters per second to meters per second.
     */
    private static void initializeSpeedConversionFactorsDecimetersPerSecond() {
        Map<Units.Speed, RealValue> factors = new EnumMap<>(Units.Speed.class);
        factors.put(Units.Speed.METERS_PER_SECOND, new RealValue(new BigDecimal(Float.toString(0.1f), App.getPrecision())));
        speedConversionFactors.put(Units.Speed.KILOMETERS_PER_SECOND, factors);
    }

    /**
     * Initializes the conversion factors for decimeters per hour to meters per second
     */
    private static void initializeSpeedConversionFactorsDecimetersPerHour() {
        Map<Units.Speed, RealValue> factors = new EnumMap<>(Units.Speed.class);
        factors.put(Units.Speed.METERS_PER_SECOND, new RealValue(new BigDecimal(Float.toString(2.777777777E-5f), App.getPrecision())));
        speedConversionFactors.put(Units.Speed.DECIMETERS_PER_HOUR, factors);
    }

    /**
     * Initializes the conversion factors for meters per second.
     */
    private static void initializeSpeedConversionFactorsKilometersPerSecond() {
        Map<Units.Speed, RealValue> factors = new EnumMap<>(Units.Speed.class);
        factors.put(Units.Speed.METERS_PER_SECOND, new RealValue(new BigDecimal(Float.toString(1000f), App.getPrecision())));
        speedConversionFactors.put(Units.Speed.DECIMETERS_PER_SECOND, factors);
    }

    /**
     * Initializes the conversion factors for meters per hour.
     */
    private static void initializeSpeedConversionFactorsKilometersPerHour() {
        Map<Units.Speed, RealValue> factors = new EnumMap<>(Units.Speed.class);
        factors.put(Units.Speed.METERS_PER_SECOND, new RealValue(new BigDecimal(Float.toString(1f/3.6f), App.getPrecision())));
        speedConversionFactors.put(Units.Speed.KILOMETERS_PER_HOUR, factors);
    }

    /**
     * Initializes the conversion factor for inches per second to meters per second.
     */
    private static void initializeSpeedConversionFactorsInchesPerSecond() {
        Map<Units.Speed, RealValue> factors = new EnumMap<>(Units.Speed.class);
        factors.put(Units.Speed.METERS_PER_SECOND, new RealValue(new BigDecimal(Float.toString(0.0254f), App.getPrecision())));
        speedConversionFactors.put(Units.Speed.INCHES_PER_SECOND, factors);
    }

    /**
     * Initializes the conversion factors for inches per hour to meters per second
     */
    private static void initializeSpeedConversionFactorsInchesPerHour() {
        Map<Units.Speed, RealValue> factors = new EnumMap<>(Units.Speed.class);
        factors.put(Units.Speed.METERS_PER_SECOND, new RealValue(new BigDecimal(Float.toString(91.44f), App.getPrecision())));
        speedConversionFactors.put(Units.Speed.INCHES_PER_HOUR, factors);
    }

    /**
     * Initializes the conversion factor for feet per second to meters per second.
     */
    private static void initializeSpeedConversionFactorsFeetPerSecond() {
        Map<Units.Speed, RealValue> factors = new EnumMap<>(Units.Speed.class);
        factors.put(Units.Speed.METERS_PER_SECOND, new RealValue(new BigDecimal(Float.toString(0.3048f), App.getPrecision())));
        speedConversionFactors.put(Units.Speed.FEET_PER_SECOND, factors);
    }

    /**
     * Initializes the conversion factors for feet per hour to meters per second
     */
    private static void initializeSpeedConversionFactorsFeetPerHour() {
        Map<Units.Speed, RealValue> factors = new EnumMap<>(Units.Speed.class);
        factors.put(Units.Speed.METERS_PER_SECOND, new RealValue(new BigDecimal(Float.toString(0.0000846667f), App.getPrecision())));
        speedConversionFactors.put(Units.Speed.FEET_PER_HOUR, factors);
    }

    /**
     * Initializes the conversion factor for yards per second to meters per second.
     */
    private static void initializeSpeedConversionFactorsYardsPerSecond() {
        Map<Units.Speed, RealValue> factors = new EnumMap<>(Units.Speed.class);
        factors.put(Units.Speed.METERS_PER_SECOND, new RealValue(new BigDecimal(Float.toString(0.9144f), App.getPrecision())));
        speedConversionFactors.put(Units.Speed.YARDS_PER_SECOND, factors);
    }

    /**
     * Initializes the conversion factors for yards per hour to meters per second
     */
    private static void initializeSpeedConversionFactorsYardsPerHour() {
        Map<Units.Speed, RealValue> factors = new EnumMap<>(Units.Speed.class);
        factors.put(Units.Speed.METERS_PER_SECOND, new RealValue(new BigDecimal(Float.toString(0.000254f), App.getPrecision())));
        speedConversionFactors.put(Units.Speed.YARDS_PER_HOUR, factors);
    }

    /**
     * Initializes the conversion factor for miles per second to meters per second.
     */
    private static void initializeSpeedConversionFactorsMilesPerSecond() {
        Map<Units.Speed, RealValue> factors = new EnumMap<>(Units.Speed.class);
        factors.put(Units.Speed.METERS_PER_SECOND, new RealValue(new BigDecimal(Float.toString(1609.344f), App.getPrecision())));
        speedConversionFactors.put(Units.Speed.MILES_PER_SECOND, factors);
    }

    /**
     * Initializes the conversion factors for miles per hour to meters per second
     */
    private static void initializeSpeedConversionFactorsMilesPerHour() {
        Map<Units.Speed, RealValue> factors = new EnumMap<>(Units.Speed.class);
        factors.put(Units.Speed.METERS_PER_SECOND, new RealValue(new BigDecimal(Float.toString(0.44704f), App.getPrecision())));
        speedConversionFactors.put(Units.Speed.MILES_PER_HOUR, factors);
    }

    /**
     * Initializes the conversion factor for knot (nautical miles per hour) to meters per second.
     */
    private static void initializeSpeedConversionFactorsKnot() {
        Map<Units.Speed, RealValue> factors = new EnumMap<>(Units.Speed.class);
        factors.put(Units.Speed.METERS_PER_SECOND, new RealValue(new BigDecimal(Float.toString(0.5144444444f), App.getPrecision())));
        speedConversionFactors.put(Units.Speed.KNOT, factors);
    }

    /**
     * Initializes the conversion factor for nautical miles per second to meters per second.
     */
    private static void initializeSpeedConversionFactorsMach() {
        Map<Units.Speed, RealValue> factors = new EnumMap<>(Units.Speed.class);
        factors.put(Units.Speed.METERS_PER_SECOND, new RealValue(new BigDecimal(Float.toString(295.0464f), App.getPrecision())));
        speedConversionFactors.put(Units.Speed.MACH, factors);
    }

    /**
     * Defines the conversion factors for all weight units.
     */
    private static void initializeWeightConversionFactors() {
        initializeWeightConversionFactorsGram();
        initializeWeightConversionFactorMilligram();
        initializeWeightConversionFactorCentigram();
        initializeWeightConversionFactorDecigram();
        initializeWeightConversionFactorKilogram();
        initializeWeightConversionFactorTon();
        initializeWeightConversionFactorOunce();
        initializeWeightConversionFactorPound();
        initializeWeightConversionFactorCarat();
        initializeWeightConversionFactorEmptyClubMateBottle();
    }

    /**
     * Initializes the conversion factor for milligram to gram.
     */
    private static void initializeWeightConversionFactorMilligram() {
        Map<Units.Weight, RealValue> factors = new EnumMap<>(Units.Weight.class);
        factors.put(Units.Weight.GRAM, new RealValue(new BigDecimal(Float.toString(0.001f), App.getPrecision())));
        weightConversionFactors.put(Units.Weight.MILLIGRAM, factors);
    }

    /**
     * Initializes the conversion factor for centigram to gram.
     */
    private static void initializeWeightConversionFactorCentigram() {
        Map<Units.Weight, RealValue> factors = new EnumMap<>(Units.Weight.class);
        factors.put(Units.Weight.GRAM, new RealValue(new BigDecimal(Float.toString(0.01f), App.getPrecision())));
        weightConversionFactors.put(Units.Weight.CENTIGRAM, factors);
    }

    /**
     * Initializes the conversion factor for decigram to gram.
     */
    private static void initializeWeightConversionFactorDecigram() {
        Map<Units.Weight, RealValue> factors = new EnumMap<>(Units.Weight.class);
        factors.put(Units.Weight.GRAM, new RealValue(new BigDecimal(Float.toString(0.1f), App.getPrecision())));
        weightConversionFactors.put(Units.Weight.DECIGRAM, factors);
    }

    /**
     * Initializes the conversion factors for gram.
     */
    private static void initializeWeightConversionFactorsGram() {
        Map<Units.Weight, RealValue> factors = new EnumMap<>(Units.Weight.class);
        factors.put(Units.Weight.MILLIGRAM, new RealValue(new BigDecimal(Float.toString(1000f), App.getPrecision())));
        factors.put(Units.Weight.CENTIGRAM, new RealValue(new BigDecimal(Float.toString(100f), App.getPrecision())));
        factors.put(Units.Weight.DECIGRAM, new RealValue(new BigDecimal(Float.toString(10f), App.getPrecision())));
        factors.put(Units.Weight.GRAM, new RealValue(new BigDecimal(Float.toString(1f), App.getPrecision())));
        factors.put(Units.Weight.KILOGRAM, new RealValue(new BigDecimal(Float.toString(0.001f), App.getPrecision())));
        factors.put(Units.Weight.TON, new RealValue(new BigDecimal(Float.toString(0.000001f), App.getPrecision())));
        factors.put(Units.Weight.OUNCE, new RealValue(new BigDecimal(Float.toString(0.0352739619f), App.getPrecision())));
        factors.put(Units.Weight.POUND, new RealValue(new BigDecimal(Float.toString(0.0022046226f), App.getPrecision())));
        factors.put(Units.Weight.CARAT, new RealValue(new BigDecimal(Float.toString(5f), App.getPrecision())));
        factors.put(Units.Weight.EMPTY_CLUB_MATE_BOTTLE, new RealValue(new BigDecimal(Float.toString(1f/358), App.getPrecision())));
        weightConversionFactors.put(Units.Weight.GRAM, factors);
    }

    /**
     * Initializes the conversion factor for kilogram to gram.
     */
    private static void initializeWeightConversionFactorKilogram() {
        Map<Units.Weight, RealValue> factors = new EnumMap<>(Units.Weight.class);
        factors.put(Units.Weight.GRAM, new RealValue(new BigDecimal(Float.toString(1000f), App.getPrecision())));
        weightConversionFactors.put(Units.Weight.KILOGRAM, factors);
    }

    /**
     * Initializes the conversion factor for ton to gram.
     */
    private static void initializeWeightConversionFactorTon() {
        Map<Units.Weight, RealValue> factors = new EnumMap<>(Units.Weight.class);
        factors.put(Units.Weight.GRAM, new RealValue(new BigDecimal(Float.toString(1000000f), App.getPrecision())));
        weightConversionFactors.put(Units.Weight.TON, factors);
    }

    /**
     * Initializes the conversion factor for ounce to gram.
     */
    private static void initializeWeightConversionFactorOunce() {
        Map<Units.Weight, RealValue> factors = new EnumMap<>(Units.Weight.class);
        factors.put(Units.Weight.GRAM, new RealValue(new BigDecimal(Float.toString(28.349523125f), App.getPrecision())));
        weightConversionFactors.put(Units.Weight.OUNCE, factors);
    }

    /**
     * Initializes the conversion factor for pound to gram.
     */
    private static void initializeWeightConversionFactorPound() {
        Map<Units.Weight, RealValue> factors = new EnumMap<>(Units.Weight.class);
        factors.put(Units.Weight.GRAM, new RealValue(new BigDecimal(Float.toString(453.59237f), App.getPrecision())));
        weightConversionFactors.put(Units.Weight.POUND, factors);
    }

    /**
     * Initializes the conversion factor for kilogram to carat.
     */
    private static void initializeWeightConversionFactorCarat() {
        Map<Units.Weight, RealValue> factors = new EnumMap<>(Units.Weight.class);
        factors.put(Units.Weight.GRAM, new RealValue(new BigDecimal(Float.toString(0.2f), App.getPrecision())));
        weightConversionFactors.put(Units.Weight.CARAT, factors);
    }

    /**
     * Initializes the conversion factor for empty club mate bottle to gram.
     */
    private static void initializeWeightConversionFactorEmptyClubMateBottle() {
        Map<Units.Weight, RealValue> factors = new EnumMap<>(Units.Weight.class);
        factors.put(Units.Weight.GRAM, new RealValue(new BigDecimal(Float.toString(358f), App.getPrecision())));
        weightConversionFactors.put(Units.Weight.EMPTY_CLUB_MATE_BOTTLE, factors);
    }

    /**
     * Defines the conversion factors for all distance units.
     */
    private static void initializeDistanceConversionFactors() {
        initializeDistanceConversionFactorsMeter();
        initializeDistanceConversionFactorKilometer();
        initializeDistanceConversionFactorMillimeter();
        initializeDistanceConversionFactorCentimeter();
        initializeDistanceConversionFactorDecimeter();
        initializeDistanceConversionFactorInch();
        initializeDistanceConversionFactorFoot();
        initializeDistanceConversionFactorYard();
        initializeDistanceConversionFactorMile();
        initializeDistanceConversionFactorNauticalMile();
        initializeDistanceConversionFactorLightYear();
    }

    /**
     * Initializes the conversion factor for millimeter to meter.
     */
    private static void initializeDistanceConversionFactorMillimeter() {
        Map<Units.Distance, RealValue> factors = new EnumMap<>(Units.Distance.class);
        factors.put(Units.Distance.METER, new RealValue(new BigDecimal(Float.toString(1000f), App.getPrecision())));
        distanceConversionFactors.put(Units.Distance.MILLIMETER, factors);
    }

    /**
     * Initializes the conversion factor for centimeter to meter.
     */
    private static void initializeDistanceConversionFactorCentimeter() {
        Map<Units.Distance, RealValue> factors = new EnumMap<>(Units.Distance.class);
        factors.put(Units.Distance.METER, new RealValue(new BigDecimal(Float.toString(100f), App.getPrecision())));
        distanceConversionFactors.put(Units.Distance.CENTIMETER, factors);
    }

    /**
     * Initializes the conversion factor for decimeter to meter.
     */
    private static void initializeDistanceConversionFactorDecimeter() {
        Map<Units.Distance, RealValue> factors = new EnumMap<>(Units.Distance.class);
        factors.put(Units.Distance.METER, new RealValue(new BigDecimal(Float.toString(10f), App.getPrecision())));
        distanceConversionFactors.put(Units.Distance.DECIMETER, factors);
    }

    /**
     * Initializes the conversion factors for meter to any distance unit.
     */
    private static void initializeDistanceConversionFactorsMeter() {
        Map<Units.Distance, RealValue> factors = new EnumMap<>(Units.Distance.class);
        factors.put(Units.Distance.MILLIMETER, new RealValue(new BigDecimal(Float.toString(1000f), App.getPrecision())));
        factors.put(Units.Distance.CENTIMETER, new RealValue(new BigDecimal(Float.toString(100f), App.getPrecision())));
        factors.put(Units.Distance.DECIMETER, new RealValue(new BigDecimal(Float.toString(10f), App.getPrecision())));
        factors.put(Units.Distance.METER, new RealValue(new BigDecimal(Float.toString(1f), App.getPrecision())));
        factors.put(Units.Distance.KILOMETER, new RealValue(new BigDecimal(Float.toString(1f/1000), App.getPrecision())));
        factors.put(Units.Distance.FOOT, new RealValue(new BigDecimal(Float.toString(3.280839895f), App.getPrecision())));
        factors.put(Units.Distance.MILE, new RealValue(new BigDecimal(Float.toString(0.0006213712f), App.getPrecision())));
        factors.put(Units.Distance.NAUTICAL_MILE, new RealValue(new BigDecimal(Float.toString(0.0005399568f), App.getPrecision())));
        factors.put(Units.Distance.LIGHT_YEAR, new RealValue(new BigDecimal(Float.toString(1.057000834E-16f), App.getPrecision())));
        distanceConversionFactors.put(Units.Distance.METER, factors);
    }

    /**
     * Initializes the conversion factor for inch to meter.
     */
    private static void initializeDistanceConversionFactorInch() {
        Map<Units.Distance, RealValue> factors = new EnumMap<>(Units.Distance.class);
        factors.put(Units.Distance.METER, new RealValue(new BigDecimal(Float.toString(0.0254f), App.getPrecision())));
        distanceConversionFactors.put(Units.Distance.INCH, factors);
    }

    /**
     * Initializes the conversion factor for kilometer to meter.
     */
    private static void initializeDistanceConversionFactorKilometer() {
        Map<Units.Distance, RealValue> factors = new EnumMap<>(Units.Distance.class);
        factors.put(Units.Distance.METER, new RealValue(new BigDecimal(Float.toString(1000f), App.getPrecision())));
        distanceConversionFactors.put(Units.Distance.KILOMETER, factors);
    }

    /**
     * Initializes the conversion factor for foot to meter.
     */
    private static void initializeDistanceConversionFactorFoot() {
        Map<Units.Distance, RealValue> factors = new EnumMap<>(Units.Distance.class);
        factors.put(Units.Distance.METER, new RealValue(new BigDecimal(Float.toString(3.280839895f), App.getPrecision())));
        distanceConversionFactors.put(Units.Distance.FOOT, factors);
    }

    /**
     * Initializes the conversion factor for yard to meter.
     */
    private static void initializeDistanceConversionFactorYard() {
        Map<Units.Distance, RealValue> factors = new EnumMap<>(Units.Distance.class);
        factors.put(Units.Distance.METER, new RealValue(new BigDecimal(Float.toString(0.9144f), App.getPrecision())));
        distanceConversionFactors.put(Units.Distance.YARD, factors);
    }

    /**
     * Initializes the conversion factor for mile to meter.
     */
    private static void initializeDistanceConversionFactorMile() {
        Map<Units.Distance, RealValue> factors = new EnumMap<>(Units.Distance.class);
        factors.put(Units.Distance.METER, new RealValue(new BigDecimal(Float.toString(0.0006213712f), App.getPrecision())));
        distanceConversionFactors.put(Units.Distance.MILE, factors);
    }

    /**
     * Initializes the conversion factor for nautical mile to meter.
     */
    private static void initializeDistanceConversionFactorNauticalMile() {
        Map<Units.Distance, RealValue> factors = new EnumMap<>(Units.Distance.class);
        factors.put(Units.Distance.METER, new RealValue(new BigDecimal(Float.toString(0.0005399568f), App.getPrecision())));
        distanceConversionFactors.put(Units.Distance.NAUTICAL_MILE, factors);
    }

    /**
     * Initializes the conversion factor for light year to meter.
     */
    private static void initializeDistanceConversionFactorLightYear() {
        Map<Units.Distance, RealValue> factors = new EnumMap<>(Units.Distance.class);
        factors.put(Units.Distance.METER, new RealValue(new BigDecimal(Float.toString(1.057000834E-16f), App.getPrecision())));
        distanceConversionFactors.put(Units.Distance.LIGHT_YEAR, factors);
    }

    /**
     * Defines the conversion factors for all time units.
     */
    private static void initializeTimeConversionFactors() {
        initializeTimeConversionFactorsSecond();
        initializeTimeConversionFactorsHour();
    }

    /**
     * Initializes the conversion factors for second.
     */
    private static void initializeTimeConversionFactorsSecond() {
        Map<Units.Time, RealValue> factors = new EnumMap<>(Units.Time.class);
        factors.put(Units.Time.SECOND, new RealValue(new BigDecimal(Float.toString(1f), App.getPrecision())));
        factors.put(Units.Time.HOUR, new RealValue(new BigDecimal(Float.toString(1f/3600), App.getPrecision())));
        timeConversionFactors.put(Units.Time.SECOND, factors);
    }

    /**
     * Initializes the conversion factors for hour.
     */
    private static void initializeTimeConversionFactorsHour() {
        Map<Units.Time, RealValue> factors = new EnumMap<>(Units.Time.class);
        factors.put(Units.Time.SECOND, new RealValue(new BigDecimal(Float.toString(3600f), App.getPrecision())));
        factors.put(Units.Time.HOUR, new RealValue(new BigDecimal(Float.toString(1f), App.getPrecision())));
        timeConversionFactors.put(Units.Time.HOUR, factors);
    }

    /**
     * Defines the conversion factors for all angles units.
     */
    private static void initializeAnglesConversionFactors() {
        initializeAnglesConversionFactorsDegree();
        initializeAnglesConversionFactorsRadian();
    }

    /**
     * Initializes the conversion factors for degree.
     */
    private static void initializeAnglesConversionFactorsDegree() {
        Map<Units.Angles, RealValue> factors = new EnumMap<>(Units.Angles.class);
        factors.put(Units.Angles.DEGREE, new RealValue(new BigDecimal(Float.toString(1f), App.getPrecision())));
        factors.put(Units.Angles.RADIAN, new RealValue(new BigDecimal(Float.toString((float) Math.PI / 180), App.getPrecision())));
        anglesConversionFactors.put(Units.Angles.DEGREE, factors);
    }

    /**
     * Initializes the conversion factors for radian.
     */
    private static void initializeAnglesConversionFactorsRadian() {
        Map<Units.Angles, RealValue> factors = new EnumMap<>(Units.Angles.class);
        factors.put(Units.Angles.DEGREE, new RealValue(new BigDecimal(Float.toString(180f / (float) Math.PI), App.getPrecision())));
        factors.put(Units.Angles.RADIAN, new RealValue(new BigDecimal(Float.toString(1f), App.getPrecision())));
        anglesConversionFactors.put(Units.Angles.RADIAN, factors);
    }

    /**
     * Retrieve the conversion factor when converting from the first given unit to the second given unit.
     *
     * @param from The unit of the value
     * @param to   The unit of the result
     * @return The conversion factor
     */
    private static RealValue getSpeedFactor(Units.Speed from, Units.Speed to) {
        return speedConversionFactors.get(from).get(to);
    }

    /**
     * Retrieve the conversion factor when converting from the first given unit to the second given unit.
     *
     * @param from The unit of the value
     * @param to   The unit of the result
     * @return The conversion factor
     */
    private static RealValue getWeightFactor(Units.Weight from, Units.Weight to) {
        return weightConversionFactors.get(from).get(to);
    }

    /**
     * Retrieve the conversion factor when converting from the first given unit to the second given unit.
     *
     * @param from The unit of the value
     * @param to   The unit of the result
     * @return The conversion factor
     */
    private static RealValue getDistanceFactor(Units.Distance from, Units.Distance to) {
        return distanceConversionFactors.get(from).get(to);
    }

    /**
     * Retrieve the conversion factor when converting from the first given unit to the second given unit.
     *
     * @param from The unit of the value
     * @param to   The unit of the result
     * @return The conversion factor
     */
    private static RealValue getTimeFactor(Units.Time from, Units.Time to) {
        return timeConversionFactors.get(from).get(to);
    }

    /**
     * Retrieve the conversion factor when converting from the first given unit to the second given unit.
     * @param from The unit of the value
     * @param to The unit of the result
     * @return The conversion factor
     */
    private static RealValue getAngleFactor(Units.Angles from, Units.Angles to) {
        return anglesConversionFactors.get(from).get(to);
    }

    /**
     * Converts the given speed from the first given unit to the second given unit.
     * First converts the value to meters per second and then to the requested unit.
     * @param value The value to convert
     * @param from The unit of the value
     * @param to The unit of the result
     * @return The converted value
     */
    private static AbstractValue convertSpeed(RealValue value, Units.Speed from, Units.Speed to) {
        return value.mul(getSpeedFactor(from, Units.Speed.METERS_PER_SECOND)).mul(getSpeedFactor(Units.Speed.METERS_PER_SECOND, to));
    }

    /**
     * Converts the given weight from the first given unit to the second given unit.
     * First converts the value to gram and then to the requested unit.
     * @param value The value to convert
     * @param from The unit of the value
     * @param to The unit of the result
     * @return The converted value
     */
    private static AbstractValue convertWeight(RealValue value, Units.Weight from, Units.Weight to) {
        return value.mul(getWeightFactor(from, Units.Weight.GRAM)).mul(getWeightFactor(Units.Weight.GRAM, to));
    }

    /**
     * Converts the given distance from the first given unit to the second given unit.
     * First converts the value to meters and then to the requested unit.
     * @param value The value to convert
     * @param from The unit of the value
     * @param to The unit of the result
     * @return The converted value
     */
    private static AbstractValue convertDistance(RealValue value, Units.Distance from, Units.Distance to) {
        return value.mul(getDistanceFactor(from, Units.Distance.METER)).mul(getDistanceFactor(Units.Distance.METER, to));
    }

    /**
     * Converts the given time from the first given unit to the second given unit.
     * @param value The value to convert
     * @param from The unit of the value
     * @param to The unit of the result
     * @return The converted value
     */
    private static AbstractValue convertTime(RealValue value, Units.Time from, Units.Time to) {
        return value.mul(getTimeFactor(from, to));
    }

    /**
     * Converts the given anlge from the first given unit to the second given unit.
     * @param value The value to convert
     * @param from The unit of the value
     * @param to The unit of the result
     * @return The converted value
     */
    private static AbstractValue convertAngle(RealValue value, Units.Angles from, Units.Angles to) {
        return value.mul(getAngleFactor(from, to));
    }

    /**
     * Converts the given value from the first given unit to the second given units.
     * This method performs the necessary checks and returns NotANumber if the units cannot be converted one to another.
     *
     * @param value The value to convert
     * @param from  The unit of the value
     * @param to    The unit of the result
     * @return The converted value
     */
    public static MyNumber convert(RealValue value, Units.Unit from, Units.Unit to) {
        if (from instanceof Units.Speed fromSpeed && to instanceof Units.Speed toSpeed) {
            AbstractValue result = convertSpeed(value, fromSpeed, toSpeed);
            return new MyNumber(result);
        }
        if (from instanceof Units.Weight fromWeight && to instanceof Units.Weight toWeight) {
            AbstractValue result = convertWeight(value, fromWeight, toWeight);
            return new MyNumber(result);
        }
        if (from instanceof Units.Distance fromDistance && to instanceof Units.Distance toDistance) {
            AbstractValue result = convertDistance(value, fromDistance, toDistance);
            return new MyNumber(result);
        }
        if (from instanceof Units.Time fromTime && to instanceof Units.Time toTime) {
            AbstractValue result = convertTime(value, fromTime, toTime);
            return new MyNumber(result);
        }
        if (from instanceof Units.Angles fromAngle && to instanceof Units.Angles toAngle) {
            AbstractValue result = convertAngle(value, fromAngle, toAngle);
            return new MyNumber(result);
        }
        return new NotANumber();
    }
}
