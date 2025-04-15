import java.util.Collection;
import java.util.List;

import static br.com.dio.model.GameStatus.NOW_STARTED;
import static java.util.Objects.nonNull;


public class Board {

  private final List<List<Space>> spaces;


  public Board(final List<List<Space>> spaces){
    this.spaces = spaces;
  }

  public List<List<Space>> getSpaces(){
    return spaces;
  }

  public GameStatus getStatus(){
    if(spaces.stream().flatMap(Collection::stream).noneMatch(s -> !s.isFixed() && nonNull(s.getAtual()))){
      return NOW_STARTED;
    }
  }
}
