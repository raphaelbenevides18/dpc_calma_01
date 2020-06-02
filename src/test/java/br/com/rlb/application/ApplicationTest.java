package br.com.rlb.application;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@SpringBootTest(classes = AppConfig.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class ApplicationTest {
	@Test
	public void testMain() {
		Runnable runnable = new Runnable() {
			@Override
			public void run() {
				Application.main(new String[]{});
			}
		};
		Thread thread = new Thread(runnable);
		thread.run();
		thread.interrupt();
	}
}
