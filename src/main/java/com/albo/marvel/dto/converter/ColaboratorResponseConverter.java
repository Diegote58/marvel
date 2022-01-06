package com.albo.marvel.dto.converter;

import com.albo.marvel.constants.Constants;
import com.albo.marvel.dto.ColaboratorResponse;
import com.albo.marvel.entity.Colaborator;
import com.albo.marvel.utils.UtilDate;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class ColaboratorResponseConverter {

	public ColaboratorResponse toColaboratorResponse(List<Colaborator> colaboratorList) {
		ColaboratorResponse colaboratorResponse = new ColaboratorResponse();
		if (colaboratorList != null && !colaboratorList.isEmpty()) {
			colaboratorResponse.setLastSync(Constants.LAST_SYNC_PREFIX + UtilDate.getFormatDate(colaboratorList.get(0).getLastModified(), Constants.LAST_SYNC_FORMAT_DATE));
			for (Colaborator c: colaboratorList) {
				switch (c.getRole()){
					case Constants.ROLE_EDITOR:
						colaboratorResponse.getEditors().add(c.getName());
						break;
					case Constants.ROLE_WRITER:
						colaboratorResponse.getWriters().add(c.getName());
						break;
					case Constants.ROLE_COLORIST:
						colaboratorResponse.getColorists().add(c.getName());
						break;
					default:
						break;

				}
			}
		}
		return colaboratorResponse;
	}
}
