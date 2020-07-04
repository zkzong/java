package com.zkzong.spring.data.redis.ibm;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.inject.Inject;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

/**
 * Created by Zong on 2017/3/28.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = LocalRedisConfig.class)
public class DictionaryDaoTest {
    @Inject
    private DictionaryDao dictionaryDao;

    @Inject
    private StringRedisTemplate redisTemplate;

    // flushAll() 命令从数据库中删除所有键，而 flushDb() 仅删除当前数据库中的键。
//    @After
//    public void tearDown() {
//        redisTemplate.getConnectionFactory().getConnection().flushDb();
//    }

    @Test
    public void addWordWithItsMeaningToDictionary() {
        String meaning = "To move forward with a bounding, drooping motion.";
        Long index = dictionaryDao.addWordWithItsMeaningToDictionary("lollop", meaning);
        assertThat(index, is(notNullValue()));
        assertThat(index, is(equalTo(1L)));
    }

    @Test
    public void shouldAddMeaningToAWordIfItExist() {
        Long index = dictionaryDao.addWordWithItsMeaningToDictionary("lollop",
                "To move forward with a bounding, drooping motion.");
        assertThat(index, is(notNullValue()));
        assertThat(index, is(equalTo(1L)));

        index = dictionaryDao.addWordWithItsMeaningToDictionary("lollop",
                "To hang loosely; droop; dangle.");
        assertThat(index, is(equalTo(2L)));
    }

    @Test
    public void shouldGetAllTheMeaningForAWord() {
        setupOneWord();
        List<String> allMeanings = dictionaryDao.getAllTheMeaningsForAWord("lollop");
        assertThat(allMeanings.size(), is(equalTo(2)));
        assertThat(allMeanings, hasItems("To move forward with a bounding, drooping motion.",
                "To hang loosely; droop; dangle."));
    }

    @Test
    public void shouldDeleteAWordFromDictionary() {
        setupOneWord();
        dictionaryDao.removeWord("lollop");
    }

    @Test
    public void shouldDeleteMultipleWordsFromDictionary() {
//        setupt
    }

    private void setupOneWord() {
        dictionaryDao.addWordWithItsMeaningToDictionary("lollop",
                "To move forward with a bounding, drooping motion.");
        dictionaryDao.addWordWithItsMeaningToDictionary("lollop",
                "To hang loosely; droop; dangle.");
    }

}