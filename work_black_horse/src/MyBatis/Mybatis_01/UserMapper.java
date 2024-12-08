package MyBatis.Mybatis_01;

import java.util.List;

/**
 * @author Frank
 * @date 2024/11/11/18:46
 */
public interface UserMapper {
    public List<User> findAll();
}