package www.george.com.serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
public class Bean implements Serializable {
    private static final long serialVersionUID = -9048289897408613385L;
    private String name;
    private final int age;
}
