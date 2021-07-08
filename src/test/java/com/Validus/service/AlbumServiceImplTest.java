package com.validus.service;

import com.validus.domain.Album;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(classes = {PersistenceContext.class})
//@TestExecutionListeners({DependencyInjectionTestExecutionListener.class, TransactionalTestExecutionListener.class})
//@Configuration
//@EnableAutoConfiguration
//@ComponentScan("com.validus.service")

/*
@RunWith(SpringRunner.class)
@EnableJpaRepositories(basePackages = "com.validus.repositories")
@EntityScan(basePackages = "com.validus.domain")
@ComponentScan(value = "com.validus")
@EnableAutoConfiguration
@ContextConfiguration(classes = MusicDBTestConfig.class)
*/
public class AlbumServiceImplTest {

    @Autowired
    private AlbumService testAlbumService;

    //@Test
    public void findAll() throws Exception {

    }

    //@Test
    public void createAlbum() throws Exception {
        Album testAlbum = new Album();
        testAlbum.setId(6L);
        testAlbum.setName("Test1");
        testAlbum.setYearReleased(2018);
        testAlbum.setLastModified(new Date());
        Album createdAlbum = testAlbumService.createAlbum(testAlbum);

        Assert.assertTrue("Album should not be null", createdAlbum != null);
        Assert.assertEquals("", createdAlbum.getName(), "Test1");
    }

    //@Test
    public void findAlbum() throws Exception {
    }

    //@Test
    public void updateAlbum() throws Exception {
    }

    //@Test
    public void deleteById() throws Exception {
    }

    //@Test
    public void delete() throws Exception {
    }

}