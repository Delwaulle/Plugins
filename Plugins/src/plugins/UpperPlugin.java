package plugins;

public class UpperPlugin implements Plugin{

	@Override
	public String transform(String s) {
		return s.toUpperCase();
	}

	@Override
	public String getLabel() {
		return "upper";
	}

}
