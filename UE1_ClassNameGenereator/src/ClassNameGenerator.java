import java.util.Random;

/**
 * Create random &quot; enterprise&quot; Java class names.
 * <p>
 * This class is a port of &quot; enterprise&quot; - a class name generator
 * written in JavaScript.
 *
 * @see <a href="https://gist.github.com/hay/1351230">https://gist.github.com/hay/1351230</a>
 * @author Claudia Maderthaner
 */
public class ClassNameGenerator {

	/*
	 * The default number of words used in the generated class name.
	 * <p>
	 * This value is used, if there is no number or a invalid number is given.
	 */
	public static final int DEFAULT_NUMBER_OF_WORDS = 3;

	// The minimum number of words used in the generated class name.
	public static final int MINIMUM_NUMBER_OF_WORDS = 2;

	private static final String[] BASE_NAMES = { "Factory", "Bean", "Wrapper", "Visitor", "Model", "Singleton",
			"Method", "Configuration", "Exception", "Error", "Property", "Value", "Identifier", "Attribute",
			"Authentication", "Policy", "Container", "Order", "Info", "Parameter", "Request", "Adapter", "Bridge",
			"Decorator", "Facade", "Proxy", "Worker", "Interpreter", "Iterator", "Observer", "State", "Strategy",
			"Template", "Comparator", "Clone", "Task", "Resolver", "Candidate", "Expression", "Predicate", "Thread",
			"Pool", "Descriptor", "Interceptor", "Definition", "Getter", "Setter", "Listener", "Proccesor", "Printer",
			"Prototype", "Composer", "Event", "Helper", "Utils", "Invocation", "Exporter", "Importer", "Serializer",
			"Callback", "Tag", "Context", "Mapping", "Advisor", "Filter", "Field", "Test", "Tests", "Connection",
			"Annotation", "Service", "Repository", "Stub", "Mock", "Instance", "Dispatcher", "Client", "Server",
			"Message", "Map", "List", "Collection", "Queue", "Manager", "Database", "Reponse", "Broadcaster", "Watcher",
			"Schema", "Mapper", "Publisher", "Consumer", "Producer", "Controller" };

	private static final String[] DECORATORS = { "Composite", "Invalid", "Supported", "Focus", "Traversal", "Abstract",
			"Transformer", "Common", "Concrete", "Autowire", "Simple", "Aware", "Aspect", "Principal", "Driven",
			"Interruptible", "Batch", "Prepared", "Statement", "Remote", "Stateless", "Session", "Transaction",
			"Transactional", "Based", "Meta", "Data", "Jms", "Readable", "Literal", "Reflective", "Scope", "Multipart",
			"Xml", "Generic", "Interface", "Advisable", "Observable", "Identifiable", "Iterable", "Distributed",
			"Notification", "Failure", "Type", "Http", "Jdbc", "User", "Custom", "Geo", "Management", "Domain" };
	
	// Not initialized variable
	private final int maxWords;

	/**
	 *This is a constructor, it's a special type of method that is used to initialize the object.
	 *It is invoked at the time of object creation.
	 *
	 * @param maxWords
	 */
	public ClassNameGenerator(final int maxWords) {
		this.maxWords = maxWords;
	}

	/**
	 * The default constructor, is a constructor that have no parameter.
	 * Object get built again with the parameter 3.
	 */
	public ClassNameGenerator() {
		this(3);
	}

	/**
	 * Method generate a new String-line, by choosing strings of the array "DECORATORS", till the maximum
	 * number of the method "calculateQuantityOfWords" minus 1, if it is already in the String-line the method choose a
	 * different string. Then a random word of the array 
	 * 
	 * @return
	 */
	public String generate() {
		StringBuilder n = new StringBuilder();
		Random r = new Random();

		for (int i = 0; i < calculateQuantityOfWords() - 1; i++) {
			String word = DECORATORS[r.nextInt(DECORATORS.length)];
			if (n.indexOf(word) < 0)
				n.append(word);
		}
		n.append(BASE_NAMES[r.nextInt(BASE_NAMES.length)]);

		return n.toString();
	}
	
	/**
	 * Calculate the quantity of words which to use
	 * 
	 * @return
	 */
	private int calculateQuantityOfWords() {
		int calculatedNumberOfWords = new Random().nextInt(maxWords) + 1;
		return calculatedNumberOfWords > MINIMUM_NUMBER_OF_WORDS ? calculatedNumberOfWords : MINIMUM_NUMBER_OF_WORDS;
	}

	/**
	 * Generate a random class name.
	 * <p>
	 * The generated class name is printed to the console.
	 *
	 * @param args maximum number of words (optional)
	 */
	public static void main(String[] args) {
		ClassNameGenerator generator = new ClassNameGenerator(getValidMaxWords(args));

		String className = generator.generate();
		System.out.println(className);
	}
	
	/**
	 * Thats a method, which returns the quantity of words
	 * 
	 * @param args
	 * @return
	 */
	private static int getValidMaxWords(String[] args) {
		// initialize maxWords with defaultNumberOfWords
		int intMaxWords = DEFAULT_NUMBER_OF_WORDS;
		if (args.length > 0) {
			try {
				int input = Integer.parseInt(args[0]);
				if (input > MINIMUM_NUMBER_OF_WORDS) {
					intMaxWords = input;
				} else {
					System.err.print("Input param is not valid.");
				}
			} catch (NumberFormatException e) {
				System.err.print("Input param is not valid.");
			}
		}
		return intMaxWords;
	}
}