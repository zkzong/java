package org.example.es.repository;

import org.example.es.entity.Article;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Component;

@Component
public interface ArticleRepository extends ElasticsearchRepository<Article, Long> {
}
