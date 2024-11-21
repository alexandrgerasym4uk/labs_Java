public class Demo {

    public static void main(String[] args) throws IllegalAccessException {
        Person person1 = new Person("John", "Doe", 30);
        Product product1 = new Product("Laptop", 999.99);
        Book book1 = new Book("Java Programming", "Jane Smith", "1234567890");
        Person person2 = new Person("Alice", "Johnson", 25);
        Product product2 = new Product("Smartphone", 499.99);
        Book book2 = new Book("Python Basics", "Tom Brown", "9876543210");

        //З рефлексією toJson
        String personJson1 = Serializer.toJson(person1);
        String bookJson1 = Serializer.toJson(book1);
        String personJson2 = Serializer.toJson(person2);
        String bookJson2 = Serializer.toJson(book2);
        String productJson1 = Serializer.toJson(product1);
        String productJson2 = Serializer.toJson(product2);

        System.out.println("JSON with Reflection:");
        System.out.println(personJson1);
        System.out.println(bookJson1);
        System.out.println(productJson1);
        System.out.println(personJson2);
        System.out.println(bookJson2);
        System.out.println(productJson2);

        //Без рефлексії toJson
        String productJsonSimple1 = SimpleSerializer.productToJson(product1);
        String productJsonSimple2 = SimpleSerializer.productToJson(product2);

        System.out.println("JSON without Reflection:");
        System.out.println(productJsonSimple1);
        System.out.println(productJsonSimple2);


        //З рефлексією toXml
        String personXML1 = Serializer.toXml(person1);
        String bookXML1 = Serializer.toXml(book1);
        String personXML2 = Serializer.toXml(person2);
        String bookXML2 = Serializer.toXml(book2);
        String productXML1 = Serializer.toXml(product1);
        String productXML2 = Serializer.toXml(product2);

        System.out.println("XML with Reflection:");
        System.out.println(personXML1);
        System.out.println(productXML1);
        System.out.println(bookXML1);
        System.out.println(personXML2);
        System.out.println(productXML2);
        System.out.println(bookXML2);

        //Без рефлексії toXml
        String productXMLSimple1 = SimpleSerializer.productToXml(product1);
        String productXMLSimple2 = SimpleSerializer.productToXml(product2);

        System.out.println("XML without Reflection:");
        System.out.println(productXMLSimple1);
        System.out.println(productXMLSimple2);


        //Часові тести toJson
        long totalTimeWithReflectionJson = 0;
        long totalTimeWithoutReflectionJson = 0;

        for (int i = 0; i < 1000; i++) {
            long startReflection = System.nanoTime();
            String jsonWithReflection = Serializer.toJson(product1);
            long endReflection = System.nanoTime();
            totalTimeWithReflectionJson += (endReflection - startReflection);

            long startNoReflection = System.nanoTime();
            String jsonWithoutReflection = SimpleSerializer.productToJson(product1);
            long endNoReflection = System.nanoTime();
            totalTimeWithoutReflectionJson += (endNoReflection - startNoReflection);
        }

        System.out.println("Average time with reflection toJson: " + totalTimeWithReflectionJson / 1000 + " ns");
        System.out.println("Average time without reflection toJson: " + totalTimeWithoutReflectionJson / 1000 + " ns");


        //Часові тести toXml
        long totalTimeWithReflectionXML = 0;
        long totalTimeWithoutReflectionXML = 0;

        for (int i = 0; i < 1000; i++) {
            long startReflection = System.nanoTime();
            String jsonWithReflection = Serializer.toXml(product2);
            long endReflection = System.nanoTime();
            totalTimeWithReflectionXML += (endReflection - startReflection);

            long startNoReflection = System.nanoTime();
            String jsonWithoutReflection = SimpleSerializer.productToXml(product2);
            long endNoReflection = System.nanoTime();
            totalTimeWithoutReflectionXML += (endNoReflection - startNoReflection);
        }

        System.out.println("Average time with reflection toXml: " + totalTimeWithReflectionXML / 1000 + " ns");
        System.out.println("Average time without reflection toXml: " + totalTimeWithoutReflectionXML / 1000 + " ns");
    }
}
