package co.fourth.tuna.domain.task.vo;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SubmitTaskWithTaskVO extends SubmitTaskVO {
	private TaskVO task;
}
