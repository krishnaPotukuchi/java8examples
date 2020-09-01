package com;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

public class FunctionsTest {

	public static void main(String[] args) {
		
		Function<String , Integer> f = i -> i.length();
		Function<String, Integer> f1 = i -> i.indexOf('o');
		Integer total = f.apply("krishna Potukuchi");
		Integer index = f1.apply("Krishna Potukuchi");
		System.out.println("Total:"+total);
		System.out.println("Index:"+index);
		
		BiFunction<Integer, Integer, Integer> func = (a,b)->a+b;
		System.out.println(func.apply(10,15));
		
		UnaryOperator<Integer>  uf = i -> i*2;
		System.out.println("UF="+uf.apply(5));
		
		BinaryOperator<Integer> bo = (a,b) ->a+b+5;
		System.out.println("BO="+bo.apply(2, 3));
		
		Predicate<Integer> noGreaterThan5 = i -> i > 5;
		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
         list.stream()
                .filter(noGreaterThan5)
                .collect(Collectors.toList()).forEach(System.out::print);		
				
		BiPredicate<String, Integer> bip = (x, y) -> x.length()==y;
		System.out.println("bip="+ bip.test("Krishna", 7));
		
		Consumer<String> consumer = (x)-> System.out.println(x);
		consumer.accept("Krishna");
		
        BiConsumer<Integer, Integer> bic = (x,y) -> System.out.println(x+y);
        bic.accept(2, 4);
         
        Supplier<Integer> sup = () -> 7;
        System.out.println("sup="+ sup.get());
        
		}

}
