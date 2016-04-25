package plugins;

public class ToLowerCasePlugin implements Plugin{

	@Override
	public String transform(String s) {
		return s.toLowerCase();
	}

	@Override
	public String getLabel() {
		return "lower";
	}

}
