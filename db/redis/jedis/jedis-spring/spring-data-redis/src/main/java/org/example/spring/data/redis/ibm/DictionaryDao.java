package com.example.spring.data.redis.ibm;

import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Repository;

import javax.inject.Inject;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Zong on 2017/3/28.
 */
@Repository
public class DictionaryDao {
    private static final String ALL_UNIQUE_WORDS = "all_unique_words";

    private StringRedisTemplate redisTemplate;

    @Inject
    public DictionaryDao(StringRedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    public Long addWordWithItsMeaningToDictionary(String word, String meaning) {
        Long index = redisTemplate.opsForList().rightPush(word, meaning);
        return index;
    }

    public List<String> getAllTheMeaningsForAWord(String word) {
        List<String> meanings = redisTemplate.opsForList().range(word, 0, -1);
        return meanings;
    }

    public void removeWord(String word) {
        redisTemplate.delete(Arrays.asList(word));
    }
}
