package com.richardjaytea.investea.service;

import com.richardjaytea.investea.model.Portfolio;
import com.richardjaytea.investea.model.User;
import com.richardjaytea.investea.repository.PortfolioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PortfolioService {

    @Autowired
    PortfolioRepository repository;

    public List<Portfolio> getPortfolios(long userId)
    {
        return repository.findByUserId(userId);
    }

    public void addPortfolio(long userId, Portfolio portfolio)
    {
        User user = new User(userId);
        portfolio.setUser(user);

        repository.save(portfolio);
    }

    public void removePortfolio(long id)
    {
        repository.deleteById(id);
    }
}
