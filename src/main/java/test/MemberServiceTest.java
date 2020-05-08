package test;

import com.yang.Application;
import com.yang.service.MemberService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.mockito.BDDMockito.given;

/**
 * @Description: TODO
 * @Author: tona.sun
 * @Date: 2019/11/04 16:48
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@Transactional
public class MemberServiceTest {
    @MockBean
    MemberService userService;

    @Test
    public void testa() {
        given(userService.getAllUser());
        System.out.println("-----------------");
    }
}
