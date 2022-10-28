package com.megatera.makaogift.backdoor;

import org.springframework.jdbc.core.*;
import org.springframework.security.crypto.password.*;
import org.springframework.web.bind.annotation.*;

import javax.transaction.*;
import java.time.*;

@RestController
@RequestMapping("backdoor")
@Transactional
public class BackdoorController {
  private final JdbcTemplate jdbcTemplate;
  private final PasswordEncoder passwordEncoder;

  public BackdoorController(JdbcTemplate jdbcTemplate, PasswordEncoder passwordEncoder) {
    this.jdbcTemplate = jdbcTemplate;
    this.passwordEncoder = passwordEncoder;
  }


  @GetMapping("setup-database")
  public String setupDatabase() {
    LocalDateTime now = LocalDateTime.now();

    jdbcTemplate.execute("DELETE FROM purchase");
    jdbcTemplate.execute("DELETE FROM person");

    jdbcTemplate.update("" +
            "INSERT INTO person(" +
            "id, user_id, encoded_password, name," +
            "amount, created_at, updated_at" +
            ")" +
            " VALUES(1, ?, ? ,?, ?, ?, ?)",
        "makaoKim",passwordEncoder.encode("makaoKim92!"),"마카오김",
        50_000L,now, now
        );

    jdbcTemplate.update("" +
            "INSERT INTO person(" +
            "id, user_id, encoded_password, name," +
            "amount, created_at, updated_at" +
            ")" +
            " VALUES(2, ?, ? ,?, ?, ?, ?)",
        "kakaoLee",passwordEncoder.encode("kakaoLee99!"),"카카오리",
        1000_000L,now, now
    );

    return "OK";
  }

  @GetMapping("change-amount")
  public String changeAmount(
      @RequestParam Long userId,
      @RequestParam Long amount
  ) {
    jdbcTemplate.update("UPDATE account SET amount=? WHERE id=?", amount,userId);

    return "OK";
  }
}
