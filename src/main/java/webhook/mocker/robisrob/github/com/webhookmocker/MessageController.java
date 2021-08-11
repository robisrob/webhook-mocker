package webhook.mocker.robisrob.github.com.webhookmocker;

import static java.util.Collections.synchronizedList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("webhook")
public class MessageController {

  private List<Object> payloads = synchronizedList(new ArrayList<>());

  @GetMapping
  public List<Object> getPayloads() {
    return payloads;
  }

  @PostMapping
  public void addPayload(@RequestBody Object payload) {
    payloads.add(payload);
  }

  @DeleteMapping
  public void deletePayload() {
    payloads.clear();
  }

}
