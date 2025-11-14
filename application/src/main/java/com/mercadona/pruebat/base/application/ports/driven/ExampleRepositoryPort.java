package com.mercadona.pruebat.base.application.ports.driven;

import com.mercadona.framework.cna.commons.interfaces.CNACrudRepository;
import com.mercadona.pruebat.base.domain.Example;

public interface ExampleRepositoryPort extends CNACrudRepository<Example, Long> { }
