package uk.co.certait.waracle.repository;

import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;
import org.springframework.data.querydsl.binding.QuerydslBindings;
import org.springframework.data.repository.PagingAndSortingRepository;

import uk.co.certait.waracle.domain.Cake;
import uk.co.certait.waracle.domain.QCake;

public interface CakeRepository extends PagingAndSortingRepository<Cake, Long>, QuerydslPredicateExecutor<Cake>,
		QuerydslBinderCustomizer<QCake> {

	@Override
	default void customize(QuerydslBindings bindings, QCake cake) {
		bindings.bind(cake.title).first((path, value) -> path.likeIgnoreCase("%" + value + "%"));
		bindings.bind(cake.desc).first((path, value) -> path.likeIgnoreCase("%" + value + "%"));
	}
}
