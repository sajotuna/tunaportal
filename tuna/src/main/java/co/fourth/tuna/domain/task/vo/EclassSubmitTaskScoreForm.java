package co.fourth.tuna.domain.task.vo;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EclassSubmitTaskScoreForm {
	Integer taskno;
	List<SubmitTaskVO> submitTaskList;
}
