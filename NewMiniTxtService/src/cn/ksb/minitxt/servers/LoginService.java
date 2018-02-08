package cn.ksb.minitxt.servers;

import java.io.IOException;

import cn.ksb.minitxt.common.entity.DataTransfer;
import cn.ksb.minitxt.common.entity.User;
import cn.ksb.minitxt.server.BaseServers;
import cn.ksb.minitxt.utils.UserUtils;

public class LoginService extends BaseServers<User> {

	@Override
	public void excuted() throws IOException {
		// TODO 编写登录相关的代码
		int result = UserUtils.doLogin(getData());
//		登录成功
//		1、查询小说分类，作为返回结果返回客户端
//		2、返回成功    由客户端重新发送请求，获取小说分类
//		在登录过程中暂先考虑第一种情况
		DataTransfer<?> dto = new DataTransfer<>();
		dto.setResult(result);
		getOut().writeObject(dto);
	}

}
