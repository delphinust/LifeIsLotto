package com.delphinust.lifeislotto.realm.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import io.realm.RealmObject;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * Created by dragonfavors on 2017-04-05.
 */

@ToString
@NoArgsConstructor
@EqualsAndHashCode
public class GameRo extends RealmObject {
    @Getter @Setter
    int gameNo;
    @Getter
    String numsStr;
    @Getter @Setter
    Date createTime;

    public List<Integer> getNumList() {
        String[] nums = numsStr.split("n");
        List<Integer> numList = new ArrayList<Integer>();
        for(String s : nums){
            s.replace("n", "");
            numList.add(Integer.getInteger(s));
        }

        return numList;
    }

    public void setNumList(List<Integer> nums) {
        if (nums.size() < 6) {
            numsStr = "";
            return;
        }

        Collections.sort(nums);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 6; i++) {
            sb.append("n" + nums.get(i));
        }
        numsStr = sb.toString();
    }
}
