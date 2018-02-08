package cn.ksb.minitxt.servers;

import java.io.IOException;


import cn.ksb.minitxt.common.entity.DataTransfer;
import cn.ksb.minitxt.common.entity.User;
import cn.ksb.minitxt.server.BaseServers;
import cn.ksb.minitxt.utils.UserUtils;

public class RegisterServer extends BaseServers<User> {

	@SuppressWarnings("unchecked")
	@Override
	public void excuted() throws IOException {
		// TODO	��дע����صĴ���
		int result = UserUtils.doRegister(getData());
		DataTransfer<?> dto = new DataTransfer();
		dto.setResult(result);
		getOut().writeObject(dto);
	}
}
