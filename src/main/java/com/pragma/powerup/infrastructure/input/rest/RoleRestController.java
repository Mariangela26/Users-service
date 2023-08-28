package com.pragma.powerup.infrastructure.input.rest;

import com.pragma.powerup.application.dto.request.RoleRequestDto;
import com.pragma.powerup.application.dto.response.RoleResponseDto;
import com.pragma.powerup.application.handler.IRoleHandler;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/v1/rol")
@RequiredArgsConstructor
public class RoleRestController {

    private final IRoleHandler roleHandler;

    @Operation(summary = "Add a new rol")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Rol created", content = @Content),
            @ApiResponse(responseCode = "409", description = "Rol already exists", content = @Content)
    })
    @PostMapping("/")
    public ResponseEntity<Void> saveRole(@Valid @RequestBody RoleRequestDto roleRequestDto){
        roleHandler.saveRole(roleRequestDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @Operation(summary = "Get all roles")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "All roles returned",
                    content = @Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = RoleResponseDto.class)))),
            @ApiResponse(responseCode = "404", description = "No data found", content = @Content)
    })
    @GetMapping("/")
    public ResponseEntity<List<RoleResponseDto>> getAllRoles(){
        return ResponseEntity.ok(roleHandler.getAllRoles());
    }


    @Operation(summary = "Get Rol By Id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Rol returned", content = @Content),
            @ApiResponse(responseCode = "409", description = "Rol already exists", content = @Content)
    })
    @GetMapping("/{id}")
    public ResponseEntity<RoleResponseDto> getRolById(@PathVariable(value = "id") Long rolId) {
        return  ResponseEntity.ok(roleHandler.getById(rolId));
    }
    @Operation(summary = "Delete Rol By Id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "202", description = "Role eliminated", content = @Content),
            @ApiResponse(responseCode = "409", description = "Role already exists", content = @Content)
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable(value = "id")Long rolId){
        roleHandler.deleteById(rolId);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
}
