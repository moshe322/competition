package org.marathon.code.competition.repository;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.marathon.code.competition.domain.User;
import org.marathon.code.competition.util.RandomDataUtil;
import org.marathon.code.competition.util.RandomUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:/META-INF/spring/applicationContext.xml")
public class UserRepositoryTest {

    @Autowired
    private UserRepository repository;
    @Test
    public void testSaveIterableOfS() {
        for (int i = 0; i < 100; i++) {
            User user = new User();
            user.setUsername(RandomStringUtils.randomAlphabetic(8));
            user.setMd5Password(DigestUtils.md5Hex(RandomStringUtils.randomAlphabetic(8)));
            user.setDisplayName(RandomDataUtil.randomChineseName());
            user.setSex(RandomUtils.nextBoolean());
            repository.save(user);
        }
    }

}
