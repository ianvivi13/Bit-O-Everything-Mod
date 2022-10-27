package com.bic.bit_o_everything.util;

import com.mojang.serialization.Codec;
import com.mojang.serialization.DataResult;

import java.util.function.Function;

public class ExtendedCodecs {
    
    public static final Codec<Double> DOUBLE_0_TO_1 = doubleRangeWithMessage(0d, 1d, (value) -> "Value must be between 0 and 1: " + value);
    
    
    
    private static <N extends Number & Comparable<N>> Function<N, DataResult<N>> checkRangeWithMessage(N min, N max, Function<N, String> errorMessage) {
        return (number) -> number.compareTo(min) >= 0 && number.compareTo(max) <= 0 ? DataResult.success(number) : DataResult.error(errorMessage.apply(number));
    }
    
    private static Codec<Double> doubleRangeWithMessage(double min, double max, Function<Double, String> errorMessage) {
        Function<Double, DataResult<Double>> function = checkRangeWithMessage(min, max, errorMessage);
        return Codec.DOUBLE.flatXmap(function, function);
    }
}
