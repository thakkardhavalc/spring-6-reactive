package guru.springframework.spring6reactive.mappers;

import guru.springframework.spring6reactive.domain.Customer;
import guru.springframework.spring6reactive.model.CustomerDTO;
import org.mapstruct.Mapper;

/**
 * Created By dhaval on 2023-07-06
 */
@Mapper
public interface CustomerMapper {

    Customer customerDtoToCustomer(CustomerDTO dto);

    CustomerDTO customerToCustomerDto(Customer customer);
}
