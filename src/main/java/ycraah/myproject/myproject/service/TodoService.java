package ycraah.myproject.myproject.service;

import ycraah.myproject.myproject.dto.TodoDTO;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public enum TodoService {
  INSTANCE;

  public void register(TodoDTO todoDTO){
    System.out.println(todoDTO);
  }

  public List<TodoDTO> getList(){
    List<TodoDTO> todoDTOS = IntStream.range(0,10).mapToObj(i -> {
      TodoDTO dto = new TodoDTO();
      dto.setTno((long)i);
      dto.setTitle("Todo..." + i);
      dto.setDueDate(LocalDate.now());

      return dto;
    }).collect(Collectors.toList());
    return todoDTOS;
  }

  public TodoDTO get(Long tno){
    TodoDTO dto = new TodoDTO();
    dto.setTno(tno);
    dto.setTitle("Sample Todo");
    dto.setDueDate(LocalDate.now());
    dto.setFinished(true);

    return dto;
  }
}
