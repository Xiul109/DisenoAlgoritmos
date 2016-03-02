import java.util.function.Function;

public class XPowX implements Function<Double, Double> {

	@Override
	public Double apply(Double t) {
		return Math.pow(t,t);
	}

}
