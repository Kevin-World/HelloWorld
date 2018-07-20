package kevin_maven_test;

import java.util.UUID;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		App obj = new App();
		
		System.out.println(obj.generateUniqueKey());
	}

	public String generateUniqueKey() {

		String id = UUID.randomUUID().toString();
		return id;

	}
}
