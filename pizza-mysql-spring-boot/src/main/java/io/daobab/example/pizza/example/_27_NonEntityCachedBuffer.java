package io.daobab.example.pizza.example;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import io.daobab.Select;
import io.daobab.example.pizza.example.base.DaobabExample;
import io.daobab.example.pizza.example.base.Executor;
import io.daobab.example.pizza.example.base.Printer;
import io.daobab.example.pizza.example.nonentity.Client;
import io.daobab.example.pizza.example.nonentity.CustomerClientCollection;
import io.daobab.statement.condition.Operator;
import io.daobab.statement.condition.base.Where;


@Component
@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
public class _27_NonEntityCachedBuffer implements DaobabExample{
	
	private @Inject CustomerClientCollection no_entity_buffer;
	
	@PostConstruct
	private void init() {
		no_entity_buffer.add(new Client("John","Brown",5));
		no_entity_buffer.add(new Client("Willie","Williams",30));
		no_entity_buffer.add(new Client("Bruce","Davis",23));
		no_entity_buffer.add(new Client("William","Miller",5));
		no_entity_buffer.add(new Client("Bruce","Brown",25));
		no_entity_buffer.add(new Client("Zachary","Maurice",15));
		no_entity_buffer.add(new Client("Bruce","Taylor",54));
		no_entity_buffer.add(new Client("William","Davis",35));
		
		
	}

	@Override
	public void test() {
		Select.from(no_entity_buffer)
			.where(Where.AND()
				.and(no_entity_buffer.colFirstName(), Operator.LIKE,"Wi%")
				.and(no_entity_buffer.colAge(), Operator.GREATER_THAN,5))
			.consumeEach(Printer::printClient);
	}
	
		public static void main(String[] args) {
			Executor.runTest(_27_NonEntityCachedBuffer.class);
		}

}
