package com.puc.aluguel.services;

import com.puc.aluguel.exceptions.BusinesException;
import com.puc.aluguel.mapper.PedidoMapper;
import com.puc.aluguel.model.dto.AgentePedidoDTO;
import com.puc.aluguel.model.dto.ContratoDTO;
import com.puc.aluguel.model.dto.PedidoDTO;
import com.puc.aluguel.model.entity.Pedido;
import com.puc.aluguel.model.enums.TipoRegistroEnum;
import com.puc.aluguel.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;


@Service
public class PedidoService {

    @Autowired
    PedidoRepository repository;

    @Autowired
    AutomovelService automovelService;

    @Autowired
    AgenteService agenteService;

    @Autowired
    ClienteService clienteService;


    @Autowired
    ContratoService contratoService;

    public PedidoDTO criarPedido(PedidoDTO pedidoDTO) {
        var patient = repository.save(PedidoMapper.INSTANCE.dtoToEntity(pedidoDTO));
        return PedidoMapper.INSTANCE.entityToDto(patient);
    }

    public PedidoDTO criarPedido(Long idAutomovel, Long idCliente, TipoRegistroEnum tipoRegistroEnum) {
        var clienteDTO = clienteService.buscarClienteDTOPorId(idCliente);

        var automovelDTO = automovelService.buscarAutomovelPorId(idAutomovel);

        var contrato = contratoService.gerarContrato(ContratoDTO.builder().dataInicioContrato(LocalDate.now()).dataFimContrato(LocalDate.now().plusDays(4)).tipoRegistroEnum(tipoRegistroEnum).build());

        var pedidoDTO = PedidoDTO.builder().automovel(automovelDTO).cliente(clienteDTO).build();

        var pedido = PedidoMapper.INSTANCE.dtoToEntity(pedidoDTO);

        pedido.setContrato(contrato);

        return PedidoMapper.INSTANCE.entityToDto(repository.save(pedido));
    }

    public List<PedidoDTO> filtrarPedido(Long id, String nomeCliente, String nomeAgente) {
        var pedidoList = repository.pedidoFiltro(id, nomeCliente, nomeAgente);
        return PedidoMapper.INSTANCE.entityToDto(pedidoList);
    }

    public PedidoDTO avaliarPedido(AgentePedidoDTO agentePedidoDTO) {
        var pedido = buscarPedidoPorId(agentePedidoDTO.getId());

        var agente = agenteService.buscarAgentePorId(agentePedidoDTO.getIdAgente());

        pedido.setAgente(agente);
        pedido.setConcideracaoAgente(agentePedidoDTO.getConcideracao());
        pedido.setParecer(agentePedidoDTO.getParecer());

        return PedidoMapper.INSTANCE.entityToDto(pedido);
    }

    public Pedido buscarPedidoPorId(Long id) {
        return repository.findById(id).orElseThrow(() -> new BusinesException("Erro ao buscar pedido"));
    }

}