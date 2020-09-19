package com.scuec.test;

import com.scuec.pojo.Article;
import com.scuec.service.ArticleService;
import com.scuec.service.impl.ArticleServiceImpl;
import org.junit.jupiter.api.Test;

/**
 * @author anonymity-0
 * @date 2020/8/29 - 5:21
 */
class ArticleServiceTest {
    private ArticleService articleService =new ArticleServiceImpl();
    @Test
    void addArtical() {
        articleService.addArtical(new Article(null,"header","content","author"
                ));
    }

    @Test
    void deleteArticalById() {
        articleService.deleteArticalById("1");
    }

    @Test
    void updateArtical() {
            articleService.updateArtical(new Article(null,"header","content","author"
                    ));
    }

    @Test
    void queryArticalById() {
    }

    @Test
    void queryArticals() {
    }
}