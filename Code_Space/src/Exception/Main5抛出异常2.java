package Exception;

public class Main5抛出异常2 {

	public static void main(String[] args) throws Exception {
		Exception originException = null;
		try {
			System.out.println(Integer.parseInt("abc"));
		} catch (Exception e) {
			originException = e;
			throw e;
		}finally {
			Exception exception = new IllegalAccessException();
			if (originException != null) {
				exception.addSuppressed(originException);
			}
			throw exception;
		}
	}

}
