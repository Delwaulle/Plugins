package plugins;

public class Cesar13 implements Plugin{

	@Override
	public String transform(String str) {
		String enc="";
		int keymod=13;
		
		for(int i=0;i<str.length();i++){
			if(str.charAt(i)==' ')
				enc+=' ';
			else if(str.charAt(i)>='0' && str.charAt(i)<='9')
				enc+=(char)(str.charAt(i)+keymod);
			else if(str.charAt(i)+keymod>'z'){
				int k=str.charAt(i)+keymod-'z';
				enc+=(char)('a'-1+k);
			}
			else if(str.charAt(i)=='\n')
				enc+='\n';
			else if(str.charAt(i)>='a' && str.charAt(i)<='z')
				enc+=(char)(str.charAt(i)+keymod);
			else{
				enc+=str.charAt(i);
			}
		}
		return enc;
	}

	@Override
	public String getLabel() {
		return "cesar 13";
	}

}
