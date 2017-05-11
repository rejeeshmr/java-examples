/*
 * Copyright 2017 MD Sayem Ahmed
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.codesod.example.validation.rule;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.codesod.example.validation.MenuRepository;
import com.codesod.example.validation.OrderDTO.OrderItem;

import org.junit.Test;

public class MenuValidatorTest {

  @Test
  public void validate_menuIdInvalid_invalid() {
    OrderItem orderItem = new OrderItem();
    orderItem.setMenuId("some menu id");
    MenuRepository menuRepository = mock(MenuRepository.class);
    when(menuRepository.menuExists(any())).thenReturn(false);

    MenuValidator validator = new MenuValidator(menuRepository);

    assertThatIllegalArgumentException()
        .isThrownBy(() -> validator.validate(orderItem));
  }

  @Test
  public void validate_menuIdNull_invalid() {
    OrderItem orderItem = new OrderItem();
    MenuRepository menuRepository = mock(MenuRepository.class);
    when(menuRepository.menuExists(any())).thenReturn(true);

    MenuValidator validator = new MenuValidator(menuRepository);

    assertThatIllegalArgumentException()
        .isThrownBy(() -> validator.validate(orderItem));
  }

  @Test
  public void validate_menuIdIsBlank_invalid() {
    OrderItem orderItem = new OrderItem();
    orderItem.setMenuId("       \t");
    MenuRepository menuRepository = mock(MenuRepository.class);
    when(menuRepository.menuExists(any())).thenReturn(true);

    MenuValidator validator = new MenuValidator(menuRepository);

    assertThatIllegalArgumentException()
        .isThrownBy(() -> validator.validate(orderItem));
  }

  @Test
  public void validate_menuIdValid_validated() {
    OrderItem orderItem = new OrderItem();
    String menuId = "some menu id";
    orderItem.setMenuId(menuId);
    MenuRepository menuRepository = mock(MenuRepository.class);
    when(menuRepository.menuExists(menuId)).thenReturn(true);

    MenuValidator validator = new MenuValidator(menuRepository);

    validator.validate(orderItem);
  }
}