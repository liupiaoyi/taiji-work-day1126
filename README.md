# taiji-work-day1126
d11.26

mvn -Pnexus dependency:tree         打包jar   (非公司网时命令)Pnexus-->Pdireck
mvn -Pnexus package -DskipTests     跳过测试
mvn -Pnexus spring-boot:run         运行程序

spring boot 特点：xml配置中无代码和请求

@EnableAutoConfiguration（exclude = {DataSourceAutoConfiguration.class}）
						---exclude 移除特定的类，使其不被自动装配
@Configurationproperties( prefix="XXX" )读配置文件中的数据，并封装成对象返回

						
					
Stream，类似高版本的Iterator，.stream().filter(num -> num != null).count();
							  .(创建Stream实例).(进行一些转换操作).(聚合)
	创建方式：1.通过Stream接口的静态工厂方法；2.通过Collection接口的默认方法stream()，把一个Collection对象转换成Stream
			1①：of方法---- Stream.of(1, 2, 3, 5);  Stream.of("taobao");
			1②：generator方法：生成一个无限长度的Stream，其元素的生成是通过给定的Supplier（这个接口可以看成一个对象的工厂，每次调用返回一个给定类型的对象）
				Stream.generate(new Supplier<Double>() {
									@Override
									public Double get() {
										return Math.random();
									}});
				Stream.generate(() -> Math.random());   Stream.generate(Math::random);
				生成一个无限长度的Stream，其中值是随机的。这个无限长度Stream是懒加载，一般这种无限长度的Stream都会配合Stream的limit()方法来用。
			1③iterate方法：Stream.iterate(1, item -> item + 1).limit(10).forEach(System.out::println); 获取一个无限长度的正整数集合的Stream，然后打印前10个。使用limit方法，否则会无限打印。
			2通过Collection子类获取Stream。Collection接口有一个stream方法，其所有子类都可以获取对应的Stream对象。
				public interface Collection<E> extends Iterable<E> {
					default Stream<E> stream() {
						return StreamSupport.stream(spliterator(), false);
					}}
	
	转换Stream：distinct()去重，新生成的Stream中没有重复的元素；
				filter() 过滤，新生成的Stream只包含符合条件的元素；
				map()：转换（mapToInt，mapToLong和mapToDouble。mapToInt就是把原始Stream转换成一个新的，都是int类型的stream）
				flatMap：和map类似，不同的是其每个元素转换得到的是Stream对象，会把子Stream中的元素压缩到父集合中；
				peek: 生成包含原Stream的新Stream，并会提供一个函数（Consumer实例），新Stream每个元素被使用都会执行此函数
				skip:   {1,2,3,4,5,6} ---> skip(4) ---> {5,6}
				
				
	
1	在IDE里启动main函数 和在 java -jar XXX.jar	启动，完全不一样
	spring-boot 统一版本方式 (1)parent;(只能有一个，但是公司的parent可能与Springboot的冲突，所以不推荐用)(2)dependecyManagement
2	new SpringApplication(XX.class).setWebEnvironment(false) 只执行main函数，不以web形式				
