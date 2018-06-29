import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.hklk.website.entity.table.ItemContent;
import com.hklk.website.entity.table.OperatingUser;
import com.hklk.website.service.ItemService;
import com.hklk.website.service.UserLoginService;
import comm.AbstractTestCase;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class serviceTest extends AbstractTestCase {
    @Autowired
    UserLoginService userLoginService;
    @Autowired
    ItemService itemService;

    @Test
    public void loginTest() {
        Map<String, String> param = new HashMap<>();
        param.put("name", "developer");
        param.put("password", "123456");

        OperatingUser temp = userLoginService.userLogin("developer", "123456");
        System.out.println(temp.getUsername());
    }

    @Test
    public void queryItem() {
        List<ItemContent> temp = itemService.queryItemList(1, 10).getObjList();
        System.out.println(temp);
    }
}
