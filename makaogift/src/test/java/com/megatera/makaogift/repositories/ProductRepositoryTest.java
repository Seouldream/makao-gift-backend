package com.megatera.makaogift.repositories;

import com.megatera.makaogift.models.*;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.test.context.*;
import org.springframework.test.context.*;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("test")
class ProductRepositoryTest {
  @Autowired
  private ProductRepository productRepository;

  @Test
  void creation() {
    List<Product> products = List.of(
        new Product(1L, "Brand-new", "양 갈래 천장 조명", 1000L, "이것만 있으면 나도 인싸! 양갈래 천장 조명입니다.",
            "https://image.ohou.se/i/bucketplace-v2-development/uploads/cards/projects/165120334937886080.jpg?w=2560&h=1536&c=c&webp=1"),
        new Product(2L, "find-wood", "Wood Desk", 1000L, "클래식 우드톤으로 만들어진 우드 데스크 입니다.",
            "https://image.ohou.se/i/bucketplace-v2-development/uploads/cards/snapshots/166487918030277241.jpeg?gif=1&w=720&webp=1"),
        new Product(3L, "blue-sky", "커피 세트", 1000L, "손님없어도 혼자 차리고 싶어지는 갬성 커피세트",
            "https://image.ohou.se/i/bucketplace-v2-development/uploads/cards/snapshots/166488578975935283.jpeg?gif=1&w=720&webp=1"),
        new Product(4L, "Cozy-House", "하얀 모니터", 2000L, "ESSENTIAL 로고가 잘 어울리는 중국산 모니터",
            "https://image.ohou.se/i/bucketplace-v2-development/uploads/cards/snapshots/166479836555156848.jpeg?gif=1&w=720&webp=1"),
        new Product(5L, "Cozy-House", "구름 비누", 500L, "몸 씻는 거랑 관계없는 LUSH 느낌 비누",
            "https://image.ohou.se/i/bucketplace-v2-development/uploads/cards/snapshots/166491938661834877.jpeg?gif=1&w=720&webp=1"),
        new Product(6L, "나는야 트롤러", "모던 3단 트롤리", 500L, "아무거나 올려놔도 갬성탬으로 만들어주는 3단 다용도 트롤리",
            "https://image.ohou.se/i/bucketplace-v2-development/uploads/cards/snapshots/166489141843422062.jpeg?gif=1&w=720&webp=1"),
        new Product(7L, "useless-ItemCollector", "쓸데없이 비싼 팬케이크 접시", 100000L, "팬 케이크를 먹으려면 값비싼 팬케이크 접시가 필요하죠!",
            "https://image.ohou.se/i/bucketplace-v2-development/uploads/cards/projects/1557666133686_aRy2J4o5Y.jpg?gif=1&w=720&webp=1"),
        new Product(8L, "HomeLess,SoulLess", "칼리오페 우드 주방식기", 2500000L, "칼리오페는 제가 지어낸 우드 종 이름으로 왠지 이 이름이면 비싼 가격이 이해되는 그럼 단어입니다.(찡긋)",
            "https://image.ohou.se/i/bucketplace-v2-development/uploads/cards/snapshots/161694347248614534.jpeg?gif=1&w=720&webp=1"),
        new Product(9L, "루시드드림", "너낌있는 스카이블루 식탁보", 500000L, "이 식탁보가 잘 어울리려면 잘 어울리는 14141235252원짜리 주방이 필요합니다.",
            "https://image.ohou.se/i/bucketplace-v2-development/uploads/cards/projects/164318295092119408.png?gif=1&w=720&webp=1"),
        new Product(10L, "LUCETE", "바깥뷰가 훤히 보이는 창문 틀", 1000L, "바깥 뷰를 아주 시원히 보여주는 창문 틀입니다. 시공포함 가격 별도",
            "https://image.ohou.se/i/bucketplace-v2-development/uploads/cards/snapshots/164800275804050816.jpeg?gif=1&w=720&webp=1"),
        new Product(11L, "RG", "LG 디스플레이 거치대", 500L, "디스플레이를 예쁘게 받쳐주는 흰색 거치대",
            "https://image.ohou.se/i/bucketplace-v2-development/uploads/cards/snapshots/166469830302202451.jpeg?gif=1&w=720&webp=1"),
        new Product(12L, "CANDLER", "옴므에르고 아로마캔들", 1000L, "옴므니 팜므니 들어가면 모든 것이 fancy 해 보이죠. Woo~ fancy",
            "https://image.ohou.se/i/bucketplace-v2-development/uploads/cards/snapshots/166000397264526293.jpeg?gif=1&w=720&webp=1")
    );

    for (Product product : products) {
      productRepository.save(product);
    }
  }
}

