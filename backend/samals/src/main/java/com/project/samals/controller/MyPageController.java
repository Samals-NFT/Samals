package com.project.samals.controller;

import com.project.samals.dto.NftDto;
import com.project.samals.dto.SaleDto;
import com.project.samals.dto.response.ResMyNftDto;
import com.project.samals.dto.response.ResMySaleLikeDto;
import com.project.samals.service.NftService;
import com.project.samals.service.SaleLikeService;
import com.project.samals.service.SaleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/mypage")
@Api(tags={"마이페이지 API"})
public class MyPageController {

    private final SaleService saleService;
    private final NftService nftService;
    private final SaleLikeService saleLikeService;

    @ApiOperation(value = "내 거래 내역 조회 (판매 + 구매 - 날짜 내림차순")
    @GetMapping("/{address}/sale")
    public ResponseEntity<List<SaleDto>> getMySaleList(@PathVariable String address){
        return new ResponseEntity<>(saleService.getMySaleList(address),HttpStatus.OK);
    }

    @ApiOperation(value = "내 민팅 내역 조회")
    @GetMapping("/{address}/mint")
    public ResponseEntity<List<NftDto>> getMyMintHistory(@PathVariable String address) {
        return new ResponseEntity<>(nftService.getMyMintHistory(address), HttpStatus.OK);
    }

    @ApiOperation(value = "내 기부 내역 조회")
    @GetMapping("/{address}/donate")
    public ResponseEntity<List<NftDto>> getMyDonateHistory(@PathVariable String address) {
        return new ResponseEntity<>(nftService.getMyDonateHistory(address), HttpStatus.OK);
    }

    @ApiOperation(value = "내 NFT 리스트 조회")
    @GetMapping("/{address}/nft")
    public ResponseEntity<List<ResMyNftDto>> getMyNftList(@PathVariable String address){
        return new ResponseEntity<>(nftService.getMyNftList(address),HttpStatus.OK);
    }

    @ApiOperation(value = "내 NFT 리스트 조회 (거래 중이지 않은)")
    @GetMapping("/{address}/nft/notOnSale")
    public ResponseEntity<List<ResMyNftDto>> getMyNftNotOnSaleList(@PathVariable String address){
        return new ResponseEntity<>(nftService.getMyNftNotSaleList(address),HttpStatus.OK);
    }

    @ApiOperation(value = "내 좋아요 리스트 조회")
    @GetMapping("/{address}/like")
    public ResponseEntity<List<ResMySaleLikeDto>> getMyLikeList(@PathVariable String address) {
        return new ResponseEntity<>(saleLikeService.getMyLikeList(address), HttpStatus.OK);
    }

    @ApiOperation(value = "내 기부 총액 조회")
    @GetMapping("/{address}/total-donate")
    public ResponseEntity<Integer> getMyTotalDonate(@PathVariable String address) {
        return new ResponseEntity<>(nftService.getMyTotalDonate(address), HttpStatus.OK);
    }


}